package main.java.serlvet;

import main.java.MyServletContextListener;
import main.java.entity.User;
import main.java.server.userserver.UserServerInter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginSerlvet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       User user = new User(username,password);
       String type = req.getParameter("type");
       UserServerInter userServerInter = (UserServerInter) MyServletContextListener.hashMap.get(type+"Server");
       userServerInter.userLogin(type,user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
