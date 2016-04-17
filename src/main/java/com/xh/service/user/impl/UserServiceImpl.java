package com.xh.service.user.impl;

import com.xh.Entity.User;
import com.xh.dao.UserDao;
import com.xh.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xh on 03/04/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getEntity(id);
    }

    public List<User> getUserList() {
        return userDao.listEntity();
    }

    public List<User> queryUserList(User user) {
        return userDao.queryEntity(user);
    }

    @Override
    public void addUser(User user) {
        userDao.saveEntity(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        userDao.updateEntity(user);
    }
}
