package main.java.dao.userdao.userdaoimpl;

import main.java.MyServletContextListener;
import main.java.dao.userdao.UserDaoInter;
import main.java.entity.User;

public class UserDaoImpl implements UserDaoInter {
    @Override
    public User userLogin(User user) {
        MyServletContextListener.hashMap.get("jdbc");
        return null;
    }
}
