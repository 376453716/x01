package com.xh.Entity;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.xh.service.MessageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by xh on 15/3/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application.xml"})
public class UserTest {

    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private MessageService messageServiceH;
    @Autowired
    private MessageService messageService;

    @Test
    public void testUser() {
        messageServiceH.sayHello();
        User user = messageServiceH.getUser(1l);
        logger.info("getUser1====" + user);
        messageService.sayHello();
        User user2 = messageService.getUser(1l);
        logger.info("getUser1====" + user2);
    }
/*    @Test
    public void testUser() {
        messageService.sayHello();
        User user = messageService.getUser("1");
        logger.info("getUser1====" + user);
        user.setName("test" + user.getName());
        messageService.update(user);
        logger.info("getUser1 after updated====" + messageService.getUser("1"));
        user.setId(2);
        user.setName("name2");
        user.setBirthday(new Date());
        messageService.insert(user);
        logger.info("getAll====" + messageService.getAll());
    }*/
}
