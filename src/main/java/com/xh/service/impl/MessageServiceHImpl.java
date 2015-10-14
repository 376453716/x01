package com.xh.service.impl;

import com.xh.Entity.User;
import com.xh.dao.MessageDao;
import com.xh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xh on 15/3/2.
 */
@Service("messageServiceH")
public class MessageServiceHImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public void sayHello() {
        System.out.println("hello=============");
    }

    @Override
    public User getUser(String id) {
        return messageDao.getUser(id);
    }

    @Override
    public int update(User user) {
        return messageDao.update(user);
    }

    @Override
    public int insert(User user) {
        return messageDao.insert(user);
    }

    @Override
    public List<User> getAll() {
        return messageDao.getAll();
    }
}
