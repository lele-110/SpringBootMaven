package com.untils.framework;

import org.apache.logging.log4j.LogManager;
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
    public LoggerInfo(){}
    public LoggerInfo(T t){
        LogManager.getLogger(t.getClass());
    }
}
