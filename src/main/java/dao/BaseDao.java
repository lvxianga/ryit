package main.java.dao;

import main.java.MyServletContextListener;
import main.java.entity.Column_Name;
import main.java.entity.MyJdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao<E> {

    protected E query(E e, String sql){
        MyJdbc jdbc = (MyJdbc) MyServletContextListener.hashMap.get("jdbc");
        E x = null;
        try {
            ResultSet resultSet = jdbc.statement.executeQuery(sql);
            x = (E)e.getClass().newInstance();
            Class c = e.getClass();
            Class r = resultSet.getClass();
            Field[] fields = c.getDeclaredFields();
            resultSet.next();
            for(Field f : fields){
                 Column_Name c1 = f.getAnnotation(Column_Name.class);
                 if(c1!=null){
                    String name = f.getType().getSimpleName();
                    String name1 = (f.getName().substring(0,1).toUpperCase())+(f.getName().substring(1));
                    Class cla = (r.getMethod("get"+name,String.class).invoke(resultSet,c1.name())).getClass();
                    if(cla.getSimpleName().equals("Integer")){
                        cla=int.class;
                    }
                    c.getMethod("set"+name1,cla).invoke(x,r.getMethod("get"+name,String.class).invoke(resultSet,c1.name()));
                 }
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
        return x;
    }

}
