package main.java.entity;

/**
 * Description
 * 该类用于表示用户，用于登录数据库的凭证
 * @author BoldPeanuts
 * @date Created on 2021/12/7
 */
@Table_Name(name = "user")
public class User {
    @Column_Name(name = "user_name")
    private String userName;
    @Column_Name(name = "user_password")
    private String password;
    @Column_Name(name = "user_identity")
    private String identity;
    @Column_Name(name = "user_contact")
    private String cotactInfo;
    @Column_Name(name = "user_status")
    private String status;

    public User(String userName, String password, String identity, String cotactInfo, String status) {
        this.userName = userName;
        this.password = password;
        this.identity = identity;
        this.cotactInfo = cotactInfo;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @param userName 用户名
     * @param password 密码
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString(){
        return "用户名："+userName+"，密码："+password+"，身份："+identity;
    }

    public String getCotactInfo() {
        return cotactInfo;
    }

    public void setCotactInfo(String cotactInfo) {
        this.cotactInfo = cotactInfo;
    }
}
