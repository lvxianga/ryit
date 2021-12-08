package main.java.dao.userdao.userdaoimpl;


import main.java.dao.BaseDao;
import main.java.dao.userdao.UserDaoInter;
import main.java.entity.User;


public class UserDaoImpl extends BaseDao<User> implements UserDaoInter {
    @Override
    public User userLogin(User user) {
        String sql = "select * from user where User_name='"+user.getUserName()+"' and User_PassWord='"+user.getPassword()+"';";
        return  query(user,sql);
    }

}
