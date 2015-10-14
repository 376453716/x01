package com.xh.dao.impl;

import com.xh.Entity.User;
import com.xh.dao.MessageDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xh on 14/10/15.
 */
@Repository("messageDaoH")
public class MessageDaoHImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactoryH;

    /**
     * gerCurrentSession 会自动关闭session，使用的是当前的session事务
     *
     * @return
     */
    public Session getSession() {
        return sessionFactoryH.getCurrentSession();
    }

    @Override
    public User getUser(String id) {
        getSession().get(User.class, id);
        return null;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
