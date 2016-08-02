package com.untils.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 缓存使用工具类
 * Created by hefule on 2016/8/2.
 */
@Service("redisUtil")
public class RedisUtil{

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 根据部分字段匹配删除key（慎用）
     * @author hefule
     * @date 2016/8/2 15:16
     * @param pattern 模糊属性，例如tutorial*，则tutorial3，tutorial2等都会删除
     */
    public void deleteByPattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     *  根据key删除value(也包括批量)
     *  @author hefule
     *  @date 2016/8/2 15:20
     *  @param keys
     */
    public void deleteByKey(final String... keys) {
        for (String key : keys) {
            if (this.exists(key)) {
                redisTemplate.delete(key);
            }
        }
    }

    /**
     *  获取所有的key
     *  @author hefule
     *  @date 2016/8/2 16:43
     *
     */
    public List<Object> loadAllKey(){
        Set<String> keys = redisTemplate.keys("*");
        return Arrays.asList(keys.toArray());
    }

    /**
     *  判断是否存在对应的key
     *  @author hefule
     *  @date 2016/8/2 15:22
     *  @param key
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     *  读取缓存
     *  @author hefule
     *  @date 2016/8/2 15:23
     *  @param key 通常是有@Cacheable的value，也可以是自定义的
     */
    public Object loadObject(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     *  写入缓存
     *  @author hefule
     *  @date 2016/8/2 15:24
     *  @param key
     *  @param value
     */
    public boolean writeObject(final String key, Object value) throws Exception {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            throw new Exception("写入缓存错误",e.getCause());
        }
        return result;
    }

    /**
     *  写入缓存
     *  @author hefule
     *  @date 2016/8/2 15:25
     *  @param key
     *  @param value
     *  @param expireTime 过期时间(s)
     */
    public boolean writeObject(final String key, Object value, Long expireTime) throws Exception {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            throw new Exception("写入缓存错误",e.getCause());
        }
        return result;
    }

    /**
     *  重命名key
     *  @author hefule
     *  @date 2016/8/2 16:01
     *
     */
    public boolean renameKey(final String oldey,final String newKey)throws Exception{
        boolean result = true;
        if(!exists(oldey)){
            throw new Exception("原始key不存在");
        }else if(oldey.equals(newKey)){
            throw new Exception("原始key与新的key不能相同");
        }else{
            redisTemplate.rename(oldey,newKey);
        }
        return result;
    }

}
