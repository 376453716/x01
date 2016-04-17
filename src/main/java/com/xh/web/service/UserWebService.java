package com.xh.web.service;

import com.xh.authentic.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by xionghao on 16/11/2015.
 */
@WebService
public interface UserWebService {

    List<User> getAllUser(@WebParam(name = "ids") String ids);
}
