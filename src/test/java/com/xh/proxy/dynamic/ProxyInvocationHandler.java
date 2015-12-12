package com.xh.proxy.dynamic;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by xionghao on 23/11/2015.
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private static Logger log = Logger.getLogger(ProxyInvocationHandler.class);
    private ProxyService service;

    public ProxyInvocationHandler(ProxyService service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.debug("before invoke");
        log.debug("proxy.getClass()..." + proxy.getClass());
        //proxy.toString call invoke,
        //log.debug("proxy.toString()..." + proxy.toString());
        log.debug("args:" + Arrays.toString(args));
        Object obj = method.invoke(service, args);
        log.debug("after invoke");
        return obj;
    }
}
