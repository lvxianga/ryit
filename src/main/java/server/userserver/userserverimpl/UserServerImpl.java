package main.java.server.userserver.userserverimpl;

import main.java.MyServletContextListener;
import main.java.dao.userdao.userdaoimpl.UserDaoImpl;
import main.java.entity.User;
import main.java.server.userserver.UserServerInter;

public class UserServerImpl implements UserServerInter {
    @Override
    public User userLogin(User user) {
        return MyServletContextListener.sc.get(UserDaoImpl.class).userLogin(user);
    }
}
