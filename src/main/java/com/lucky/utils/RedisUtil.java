package com.lucky.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by 风萧萧兮 on 2017/7/24.
 * redis的工具类
 */
@Component
public class RedisUtil<T> {
    private Logger log = LogManager.getLogger(RedisUtil.class);
    @Resource
    private RedisTemplate<String,T> redisTemplate;


    /**
     * 判断缓冲中是否有对应的value
     * @param key
     * @return
     */
    public boolean isExists(String key){
        log.info("判断是否存在键为"+key+"的对象");

        return redisTemplate.hasKey(key);
    }

    /**
     * 删除键为key的对象
     * @param key
     */
    public void deleteCache(String key){
        log.info("删除键为"+key+"的对象");
        redisTemplate.delete(key);
    }

    /**
     * 获取键为key的value对象
     * @param key
     * @return
     */
    public T getCacheValue(String key){
        log.info("获取键为"+key+"的value对象");
        T result = null;
        ValueOperations<String,T> valOps = redisTemplate.opsForValue();
        result = valOps.get(key);
        return result;
    }

    /**
     * 存储键为key的value对象
     * @param key
     * @param t
     * @return
     */
    public boolean setCacheValue(String key,T t){
        log.info("存储键为"+key+"的value对象");
        boolean result = false;
        try{
            ValueOperations<String,T> valOps = redisTemplate.opsForValue();
            valOps.set(key,t);
            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}

