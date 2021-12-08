package main.java.dao;

import main.java.MyServletContextListener;
import main.java.entity.MyJdbc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao<E> {

    protected E query(E e, String sql){
        MyJdbc jdbc = (MyJdbc) MyServletContextListener.hashMap.get("jdbc");
        try {
            ResultSet resultSet = jdbc.statement.executeQuery(sql);
            Boolean flag = resultSet.next();
//            E e1 = null;
//            while(resultSet.next()){
//                String user_Name = resultSet.getString("User_name");
//                String user_PassWord = resultSet.getString("User_password");
//                String user_status = resultSet.getString("User_status");
//                String user_Contact = resultSet.getString("User_Contact");
//                String user_Identity = resultSet.getString("User_Identity");
//
//                e1 =  new E( user_Name, user_PassWord,  user_Identity, user_Contact,user_status);
//            }
            E x = (E)e.getClass().newInstance();
            Class c = e.getClass();

        } catch (SQLException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        return e;
    }

}
