package com.xh.Entity;

import com.xh.web.service.UserWebService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by xionghao on 16/11/2015.
 */
public class XWebServiceTest {

    private final static Logger log = Logger.getLogger(XWebServiceTest.class);

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/client.xml");
        UserWebService service = (UserWebService) context.getBean("client");
        List<User> users = service.getAllUser("123");
        log.info(users);
    }
}
