package main.java.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MyJdbc {

    private  Statement statement;
    private Connection conn;
    public MyJdbc() {
        ResourceBundle bundle = ResourceBundle.getBundle("C:\\Users\\86185\\IdeaProjects\\Ryit_Management\\src\\main\\resources\\MySql.properties");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            statement  = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Myclose(){
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
