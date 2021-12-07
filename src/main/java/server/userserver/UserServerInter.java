package main.java.server.userserver;

import main.java.entity.User;

public interface UserServerInter {

    User userLogin(String type,User user);

}
