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
    private MessageDao messageDaoH;

    @Override
    public void sayHello() {
        System.out.println("hello=============");
    }

    @Override
    public User getUser(Long id) {
        return messageDaoH.getEntity(id);
    }

    @Override
    public void update(User user) {
        messageDaoH.updateEntity(user);
    }

    @Override
    public void insert(User user) {
        messageDaoH.saveEntity(user);
    }

    @Override
    public List<User> getAll() {
        return messageDaoH.listEntity();
    }
}
