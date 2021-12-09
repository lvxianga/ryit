package main.java.serlvet;

import com.google.gson.Gson;
import main.java.MyServletContextListener;
import main.java.entity.User;
import main.java.server.userserver.UserServerInter;
import main.java.server.userserver.userserverimpl.UserServerImpl;

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
       User newUser = MyServletContextListener.sc.get(UserServerImpl.class).userLogin(user);
        Gson gson = new Gson();
        String javajson = gson.toJson(newUser);
        resp.getWriter().println(javajson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
