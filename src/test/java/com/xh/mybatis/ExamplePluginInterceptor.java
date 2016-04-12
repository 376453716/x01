package com.xh.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by xh on 21/01/16.
 */

@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class ExamplePluginInterceptor implements Interceptor {
    Logger log = LoggerFactory.getLogger(ExamplePluginInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info(invocation.getTarget().toString());
        log.info(invocation.getArgs().toString());
        log.info(invocation.getClass().toString());
        log.info(invocation.getMethod().getName());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
