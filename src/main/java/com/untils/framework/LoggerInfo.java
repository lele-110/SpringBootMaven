package com.untils.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 日志公用类
 * Created by hefule on 2016/8/2.
 */
public class LoggerInfo<T> {
    @Autowired
    @Qualifier("redisUtil")
    protected RedisUtil redisUtil;
    //日志私有属性
    protected Logger logger;
    public LoggerInfo(){}
    public LoggerInfo(T t){
        logger =  LogManager.getLogger(t.getClass());
    }
}
