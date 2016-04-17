package com.xh.authentic.service;

import com.xh.authentic.dao.RoleDao;
import com.xh.authentic.dao.UserDao;
import com.xh.authentic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xh on 2016/4/17.
 */
@Service("authenticService")
public class AuthenticServiceImpl implements AuthenticService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUser(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.listEntity();
    }

    @Override
    public List<User> queryUserList(User user) {
        return userDao.listByExecuteHQL("from User u where u.name like ?", "%" + user.getName() + "%");
//        return userDao.listByExecuteHQL("from User u ");
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        userDao.updateEntity(user);
    }
}
