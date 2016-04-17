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

    public void saveEntity(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    public void updateEntity(Object entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    public List<T> listEntity() {
        return (List<T>) this.getHibernateTemplate().find("From User");
    }

    @Override
    public List<T> queryEntity(T entity) {
        return (List<T>) this.getHibernateTemplate().find("From User");
    }

    public T getEntity(PK id) {
        T entity = this.getHibernateTemplate().get(entityClass, id);
        return entity;
    }
}
