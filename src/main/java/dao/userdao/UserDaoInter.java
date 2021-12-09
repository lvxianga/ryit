package main.java.dao.userdao;

import main.java.entity.User;
import java.util.ArrayList;

public interface UserDaoInter {
    /**
     * 查询单个符合条件的用户
     * @param user 当前用户
     * @return 返回一个用户对象
     */
    public User userLogin(User user);

    /**
     * 创建用户
     * @param user 需要创建的用户对象
     * @return 返回是否更新成功
     */
    public boolean createUser(User user);

    /**
     * 更新指定用户信息
     * @param user 需要更新的用户
     * @return 返回是否更新成功
     */
    public boolean updateUser(User user);

    /**
     * 删除指定用户
     * @param user 需要删除的用户
     * @return 返回是否删除成功
     */
    public boolean deleteUser(User user);

    /**
     * 查询所有用户
     * @return 返回查询表数据的集合
     */
    public ArrayList<User> queryAllUser();

    /**
     * 模糊查询所有符合条件的用户
     * @param user 用户条件信息
     * @return 返回查询表数据的集合
     */
    public ArrayList<User> fizzyQueryUser(User user);
}
