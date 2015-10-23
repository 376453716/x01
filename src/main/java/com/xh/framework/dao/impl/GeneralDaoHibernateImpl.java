package com.xh.framework.dao.impl;

import com.xh.framework.dao.IGeneralDao;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xionghao on 22/10/2015.
 */
public abstract class GeneralDaoHibernateImpl<T, PK extends Serializable> extends HibernateDaoSupport implements IGeneralDao<T, PK> {

    Logger logger = Logger.getLogger(this.getClass());

    private Class<T> entityClass;

    public GeneralDaoHibernateImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void saveEntity(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void updateEntity(Object entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public List<T> listEntity() {
        this.getHibernateTemplate().find("From User");
        return null;
    }

    @Override
    public T getEntity(PK id) {
        T entity = this.getHibernateTemplate().get(entityClass, id);
        return entity;
    }
}
