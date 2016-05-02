package com.xh.authentic.dao;

import com.xh.authentic.entity.Resource;
import com.xh.framework.dao.impl.GeneralDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xh on 2016/4/27.
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends GeneralDaoHibernateImpl<Resource, Long> implements ResourceDao {

    public ResourceDaoImpl() {
        super(Resource.class);
    }

    @Autowired
    public void setHibernateTemplate2(HibernateTemplate hibernateTemplate) {
        super.setHibernateTemplate(hibernateTemplate);
    }
}
