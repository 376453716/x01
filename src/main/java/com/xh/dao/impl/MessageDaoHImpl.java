package com.xh.dao.impl;

import com.xh.authentic.entity.User;
import com.xh.dao.MessageDao;
import com.xh.framework.dao.impl.GeneralDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xh on 14/10/15.
 */
@Repository("messageDaoH")
public class MessageDaoHImpl extends GeneralDaoHibernateImpl<User, Long> implements MessageDao {

    public MessageDaoHImpl() {
        super(User.class);
    }

    @Autowired
    public void setHibernateTemplate2(HibernateTemplate hibernateTemplate) {
        super.setHibernateTemplate(hibernateTemplate);
    }
}
