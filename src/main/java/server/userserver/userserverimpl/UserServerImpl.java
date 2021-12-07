package main.java.server.userserver.userserverimpl;

import main.java.MyServletContextListener;
import main.java.dao.userdao.UserDaoInter;
import main.java.entity.User;
import main.java.server.userserver.UserServerInter;

public class UserServerImpl implements UserServerInter {
    @Override
    public User userLogin(String type,User user) {
        UserDaoInter userDaoInter = (UserDaoInter) MyServletContextListener.hashMap.get(type+"Dao");
        return userDaoInter.userLogin(user);

    }
}
