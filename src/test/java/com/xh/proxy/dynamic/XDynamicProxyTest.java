package com.xh.proxy.dynamic;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by xionghao on 23/11/2015.
 */
public class XDynamicProxyTest {
    private final Logger log = Logger.getLogger(XDynamicProxyTest.class);

    @Test
    public void proxyTest() {
        InvocationHandler handler = new ProxyInvocationHandler(new ProxyServiceImpl());
        ProxyService service = (ProxyService) Proxy.newProxyInstance(ProxyService.class.getClassLoader(),
                new Class[]{ProxyService.class}, handler);
        service.sayHello();
        for (Method method : service.getClass().getMethods()) {
            log.info("method:" + method.getName());
        }

        log.debug(service.getClass().getName());
        log.debug(service.getClass().getSuperclass().getName());
        log.debug(Arrays.toString(service.getClass().getInterfaces()));
    }
}
