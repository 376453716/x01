package com.xh.service;

import com.xh.Entity.User;

import java.util.List;

/**
 * Created by xh on 15/3/2.
 */
public interface MessageService {
    void sayHello();

    User getUser(Long id);

    void update(User user);

    void insert(User user);

    List<User> getAll();
}
