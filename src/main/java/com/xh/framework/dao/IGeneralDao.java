package com.xh.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xionghao on 22/10/2015.
 */
public interface IGeneralDao<T, PK extends Serializable> {

    void saveEntity(T entity);

    void updateEntity(T entity);

    T getEntity(PK id);

    List<T> listEntity();

    List<T> queryEntity(T entity);

    public void saveOrUpdate(T newInstance);

    public T merge(T newInstance);

    public PK save(T newInstance);

    public void update(T newInstance);

    public void delete(T newInstance);

    public T get(PK id);

    public List<T> list(String hql);

    public int countAll();

    public List<T> listByPars(String hql, Object... pars);

    public T getByPars(String hql, Object... pars);

    public T getBySQL(String sql, Object... pars);

    public List<T> listBySQL(String sql, Object... pars);

    public List listByExecuteSQL(String sql, Object... pars);

    public Object getByExecuteSQL(String sql, Object... pars);

    public Object getByExecuteHQL(String hql, Object... pars);

    public List listByExecuteHQL(String hql, Object... pars);

    public int countByHQL(String hql, Object... pars);

    public int countBySQL(String sql, Object... pars);

    //HQL£¬É¾¸Ä
    public int executeHQL(String hql, Object... pars);

    //SQL,Ôö¸Ä
    public int executeSQL(String sql, Object... pars);

    public void saveOrUpdateEntity(Object obj);
}
