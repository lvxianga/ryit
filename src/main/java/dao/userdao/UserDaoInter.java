package main.java.dao.userdao;

import main.java.entity.User;
import java.util.ArrayList;

public interface UserDaoInter {
    public User userLogin(User user);
    public User query(User user);
    public boolean create(User user);
    public boolean update(User user);
    public boolean delete(User user);
    public ArrayList<User> queryAll();
}
