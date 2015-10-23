package com.xh.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xionghao on 22/10/2015.
 */
public interface IGeneralDao<T, PK extends Serializable> {

    public void saveEntity(T entity);

    public void updateEntity(T entity);

    public T getEntity(PK id);

    public List<T> listEntity();
}
