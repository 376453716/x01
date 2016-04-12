package com.xh.service.user;

import com.xh.Entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xh on 03/04/16.
 */
public interface UserService {

    User getUser(Long id);

    List<User> getUserList();

    List<User> queryUserList(User user);

    void addUser(User user);

    void updateUser(User user, Long id);


}
