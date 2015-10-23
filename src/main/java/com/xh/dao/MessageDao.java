package com.xh.dao;

import com.xh.Entity.User;
import com.xh.framework.dao.IGeneralDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xh on 15/3/22.
 */
public interface MessageDao extends IGeneralDao<User, Long> {
}
