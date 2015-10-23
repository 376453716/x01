package com.xh.service.impl;

import com.xh.Entity.User;
import com.xh.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xh.service.MessageService;

import java.util.List;

/**
 * Created by xh on 15/3/2.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public void sayHello() {
        System.out.println("hello=============");
    }

    @Override
    public User getUser(Long id) {
        return messageDao.getEntity(id);
    }

    @Override
    public void update(User user) {
        messageDao.updateEntity(user);
    }

    @Override
    public void insert(User user) {
        messageDao.saveEntity(user);
    }

    @Override
    public List<User> getAll() {
        return messageDao.listEntity();
    }
}
