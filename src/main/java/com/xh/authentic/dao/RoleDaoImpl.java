package com.xh.authentic.dao;

import com.xh.authentic.entity.Role;
import com.xh.framework.dao.impl.GeneralDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xh on 2016/4/17.
 */
@Repository("roleDao")
public class RoleDaoImpl extends GeneralDaoHibernateImpl<Role, Long> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }

    @Autowired
    public void setHibernateTemplate2(HibernateTemplate hibernateTemplate) {
        super.setHibernateTemplate(hibernateTemplate);
    }
}
