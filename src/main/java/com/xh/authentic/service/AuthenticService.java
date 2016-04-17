package com.xh.authentic.service;

import com.xh.authentic.entity.User;

import java.util.List;

/**
 * Created by xh on 2016/4/17.
 */
public interface AuthenticService {

    User getUser(Long id);

    List<User> getUserList();

    List<User> queryUserList(User user);

    void addUser(User user);

    void updateUser(User user, Long id);
}
