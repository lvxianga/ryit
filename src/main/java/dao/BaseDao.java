package main.java.dao;

import main.java.MyServletContextListener;
import main.java.entity.Column_Name;
import main.java.entity.MyJdbc;
import main.java.entity.Table_Name;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDao<E> {
    /**
     * 该集合装属性和值用来配条件，如果e为空返回空集
   * @param e 当前的对象
     * @return 返回当前对象所有属性和非空值
     */
    protected HashMap<String,String> getMap(E e){
        HashMap<String,String> hm = new HashMap<>(16);
        Class c = e.getClass();
        Field[] f = c.getDeclaredFields();
        try {
            for(Field field : f){
                if(field.getAnnotation(Column_Name.class) != null){
                    String name = field.getName().substring(0,1)+field.getName().substring(1);
                    Object o = c.getMethod("get"+name).invoke(e);
                    if(o != null){
                        hm.put(field.getAnnotation(Column_Name.class).name(),o.toString());
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        return hm;
    }

    /**
     *  拼sql语句用
     * @param e 当前对象
     * @param flag true精准查询，false模糊查询
     * @return 返回条件语句
     */
    protected String getQuerySql(E e,boolean flag){
        HashMap<String,String> hm = getMap(e);
        StringBuffer condition = new StringBuffer();
        int count = 0;
        String char1 = flag?" = ":" like ";
        String char2 = flag?"'":"%";
        for(String s : hm.keySet()){
            String name = hm.get(s);
            if(!name.matches("(\\d)*")){ name=char2+name+char2;}
            condition.append(s+char1+name);
            if(count > 0){condition.append(" and ");}
            count++;
        }
        return condition.toString();
    }

    /**
     * 返回查询出来的结果集，为空说明什么都没有
     * @param e 当前对象
     * @param flag true精准查询，false模糊查询
     * @param flag1 true加了条件的查询，false查询整张表
     * @return
     */
    protected ResultSet getResultSet(E e,boolean flag,boolean flag1){
        MyJdbc jdbc = (MyJdbc) MyServletContextListener.hashMap.get("jdbc");
        //判断mysql是否登陆成功
        if(jdbc.statement == null) {return null;}
        //拿到表名
        String tableName = e.getClass().getAnnotation(Table_Name.class).name();
        //在这里拼查询语句
        String sql = "select * from "+tableName;
        if(flag1){sql+=" where "+getQuerySql(e,flag)+";";}else{sql+=";";}
        try {
            ResultSet resultSet = jdbc.statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 返回查询出来的对象
     * @param e 当前对象
     * @param flag true精准查询，false模糊查询
     * @param flag1 true带条件，false查询整张表
     * @return
     */
    protected ArrayList<E> query(E e, boolean flag, boolean flag1){
        //连接数据库
        MyJdbc jdbc = (MyJdbc) MyServletContextListener.hashMap.get("jdbc");
        //拿到结果集
        ResultSet resultSet = getResultSet(e,flag,flag1);
        //判断是否拿到
        if(resultSet == null) { return null; }
        //反射对象并加到集合中
        ArrayList<E> al = new ArrayList();
        E x = null;
        try {
            Class c = e.getClass();
            Class r = resultSet.getClass();
            Field[] fields = c.getDeclaredFields();
            while(resultSet.next()){
                x = (E)e.getClass().newInstance();
                for(Field f : fields){
                    Column_Name c1 = f.getAnnotation(Column_Name.class);
                    if(c1!=null){
                        String name = f.getType().getSimpleName();
                        String name1 = (f.getName().substring(0,1).toUpperCase())+(f.getName().substring(1));
                        Class cla = (r.getMethod("get"+name,String.class).invoke(resultSet,c1.name())).getClass();
                        if(cla.getSimpleName().equals("Integer")){ cla=int.class; }
                        c.getMethod("set"+name1,cla).invoke(x,r.getMethod("get"+name,String.class).invoke(resultSet,c1.name()));
                    }
                }
                al.add(x);
            }
        } catch (SQLException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return al;
    }

    /**
     * 查询单个
     * @param e 当前对象
     * @return 返回查出来的对象
     */
    protected E querySingle(E e){
        return query(e,true,true).get(0);
    }

    /**
     * 查询所有
     * @param e 当前对象
     * @return 返回查出来的对象
     */
    protected ArrayList<E> queryAll(E e){
        return query(e,false,false);
    }

    /**
     * 模糊查询
     * @param e 当前对象
     * @return 返回查出来的对象
     */
    protected ArrayList<E> fizzyQuery(E e){
        return query(e,false,true);
    }

    /**
     * 数据更新
     * @param sql 接收sql语句
     * @return 返回是否更新成功
     */
    protected boolean dataUpdate(String sql){
        MyJdbc jdbc = (MyJdbc) MyServletContextListener.hashMap.get("jdbc");
        Statement statement = jdbc.statement;
        int i = 0;
        if(statement != null){
            try {
                i = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i != 0;
    }

    /**
     * 增加
     * @param e 当前对象
     * @return 返回是否插入成功
     */
    protected boolean create(E e){
        HashMap<String,String> hm = getMap(e);
        StringBuffer sql = new StringBuffer("insert into ");
        sql.append(e.getClass().getAnnotation(Table_Name.class).name()+"(");
        StringBuffer value = new StringBuffer(" values(");
        int count = hm.size()-1;
        for(String s: hm.keySet()){
           sql.append(s);
           value.append(hm.get(s));
           if(count > 0){ sql.append(",");value.append(","); }
           count--;
        }
        sql.append(") "+value+");");
        return dataUpdate(sql.toString());
    }

    protected boolean update(E e){

        return false;
    }

    /**
     * 删除
     * @param e 当前对象
     * @return 返回是否删除成功
     */
    protected boolean delete(E e){
        String sql = "delete from "+e.getClass().getAnnotation(Table_Name.class).name()+" where "+getQuerySql(e,true)+";";
        return dataUpdate(sql);
    }
}
