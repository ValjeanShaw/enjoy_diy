package com.lucky.utils;

import com.lucky.EnjoyDiyApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 600006
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EnjoyDiyApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    //直接使用redisTemplate存取字符串
    public void setAndGet() {
        redisTemplate.opsForValue().set("testKey", "testValue1");
        Assert.assertEquals("testValue1", redisTemplate.opsForValue().get("testKey"));
    }

}
