package com.xh.framework.dao.impl;

import com.xh.framework.dao.IGeneralDao;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.sql.SQLException;
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

    public Class<T> getPersistentClass() {
        return entityClass;
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

    @Override
    public void saveOrUpdate(T entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public T merge(T entity) {
        return this.getHibernateTemplate().merge(entity);
    }

    @Override
    public PK save(T entity) {
        return (PK) this.getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public T get(PK id) {
        return this.getHibernateTemplate().get(getPersistentClass(), id);
    }

    @Override
    public List<T> list(String hql) {
        return (List<T>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public int countAll() {
        return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(getPersistentClass());
                criteria.setProjection(Projections.rowCount());
                return ((Number) criteria.uniqueResult()).intValue();
            }
        });
    }

    @Override
    public List<T> listByPars(String hql, Object... pars) {
        return (List<T>) this.getHibernateTemplate().find(hql, pars);
    }

    @Override
    public T getByPars(String hql, Object... pars) {
        return (T) this.getHibernateTemplate().find(hql, pars).get(0);
    }

    @Override
    public T getBySQL(final String sql, final Object... pars) {
        return (T) this.getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(sql);
                if (pars != null) {
                    for (int i = 0; i < pars.length; i++) {
                        query.setParameter(i, pars[i]);
                    }
                }
                query.addEntity(getPersistentClass());
                return query.uniqueResult();
            }
        });
    }

    @Override
    public List<T> listBySQL(final String sql, final Object... pars) {
        return (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(sql);
                if (pars != null) {
                    for (int i = 0; i < pars.length; i++) {
                        query.setParameter(i, pars[i]);
                    }
                }
                query.addEntity(getPersistentClass());
                return query.list();
            }
        });
    }

    @Override
    public List listByExecuteSQL(String sql, Object... pars) {
        return null;
    }

    @Override
    public Object getByExecuteSQL(String sql, Object... pars) {
        return null;
    }

    @Override
    public Object getByExecuteHQL(String hql, Object... pars) {
        return null;
    }

    @Override
    public List listByExecuteHQL(String hql, Object... pars) {
        return this.getHibernateTemplate().find(hql, pars);
    }

    @Override
    public int countByHQL(String hql, Object... pars) {
        return 0;
    }

    @Override
    public int countBySQL(String sql, Object... pars) {
        return 0;
    }

    @Override
    public int executeHQL(String hql, Object... pars) {
        return 0;
    }

    @Override
    public int executeSQL(String sql, Object... pars) {
        return 0;
    }

    @Override
    public void saveOrUpdateEntity(Object obj) {

    }

    public T getEntity(PK id) {
        T entity = this.getHibernateTemplate().get(entityClass, id);
        return entity;
    }
}
