package com.xh.dao;

import com.xh.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xh on 15/3/22.
 */
public interface MessageDao {
    User getUser(String id);

    int update(User user);

    int insert(User user);

    List<User> getAll();
}
