package com.xh.proxy.dynamic;

import org.apache.log4j.Logger;

/**
 * Created by xionghao on 23/11/2015.
 */
public class ProxyServiceImpl implements ProxyService {
    private final Logger log = Logger.getLogger(ProxyServiceImpl.class);

    @Override
    public String sayHello() {
        log.debug("ProxyServiceImpl......");
        return "hello";
    }

    @Override
    public void log(String msg) {
        log.info("method call......" + msg);
    }
}
