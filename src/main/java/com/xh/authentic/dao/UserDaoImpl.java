package com.xh.authentic.dao;

import com.xh.authentic.entity.User;
import com.xh.framework.dao.impl.GeneralDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xh on 2016/4/17.
 */
@Repository("userDao")
public class UserDaoImpl extends GeneralDaoHibernateImpl<User, Long> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Autowired
    public void setHibernateTemplate2(HibernateTemplate hibernateTemplate) {
        super.setHibernateTemplate(hibernateTemplate);
    }
}
