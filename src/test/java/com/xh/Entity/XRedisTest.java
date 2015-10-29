package com.xh.Entity;

import com.xh.service.MessageService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xionghao on 27/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application.xml"})
public class XRedisTest {

    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testUser() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Assert.assertNull(valueOperations.get("a"));
        valueOperations.set("a", "1000");
        Assert.assertEquals(valueOperations.get("a"), "1000");
        logger.info(redisTemplate.keys("*"));
    }
}