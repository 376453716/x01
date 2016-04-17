package com.xh.service.impl;

import com.xh.authentic.entity.User;
import com.xh.dao.MessageDao;
import com.xh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xh on 15/3/2.
 */
@Service("messageServiceH")
@Transactional(propagation = Propagation.REQUIRED)
public class MessageServiceHImpl implements MessageService {
    @Autowired
    private MessageDao messageDaoH;

    @Override
    public void sayHello() {
        System.out.println("hello=============");
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return messageDaoH.listEntity();
    }
}
