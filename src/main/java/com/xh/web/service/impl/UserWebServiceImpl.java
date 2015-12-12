package com.xh.web.service.impl;

import com.xh.Entity.User;
import com.xh.service.MessageService;
import com.xh.web.service.UserWebService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by xionghao on 16/11/2015.
 */
@Service("userWebService")
@WebService(endpointInterface = "com.xh.web.service.UserWebService")
public class UserWebServiceImpl implements UserWebService {
    private final static Logger log = Logger.getLogger(UserWebServiceImpl.class);
    @Autowired
    private MessageService messageService;

    public List<User> getAllUser(String ids) {
        log.info(ids);
        return messageService.getAll();
    }
}
