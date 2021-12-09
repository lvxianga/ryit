package main.java.dao.userdao.userdaoimpl;


import main.java.dao.BaseDao;
import main.java.dao.userdao.UserDaoInter;
import main.java.entity.User;

import java.util.ArrayList;


public class UserDaoImpl extends BaseDao<User> implements UserDaoInter {
    @Override
    public User userLogin(User user) {
        String sql = "select * from user where User_name='"+user.getUserName()+"' and User_PassWord='"+user.getPassword()+"';";
        return  null;
    }

    @Override
    public User query(User user) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public ArrayList<User> queryAll() {
        return null;
    }

}
