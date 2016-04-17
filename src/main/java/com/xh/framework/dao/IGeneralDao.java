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
}
