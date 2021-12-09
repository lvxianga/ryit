package main.java.dao.userdao.userdaoimpl;


import main.java.dao.BaseDao;
import main.java.dao.userdao.UserDaoInter;
import main.java.entity.User;

import java.util.ArrayList;


public class UserDaoImpl extends BaseDao<User> implements UserDaoInter {

    @Override
    public User userLogin(User user) {
        return querySingle(user);
    }

    @Override
    public boolean createUser(User user) {
        return create(user);
    }

    @Override
    public boolean updateUser(User user) {
        return update(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public ArrayList<User> queryAllUser() {
        return queryAll(new User());
    }

    @Override
    public ArrayList<User> fizzyQueryUser(User user) {
        return fizzyQuery(user);
    }


}
