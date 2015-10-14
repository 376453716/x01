package com.xh.service;

import com.xh.Entity.User;

import java.util.List;

/**
 * Created by xh on 15/3/2.
 */
public interface MessageService {
    void sayHello();

    User getUser(String id);

    int update(User user);

    int insert(User user);

    List<User> getAll();
}
