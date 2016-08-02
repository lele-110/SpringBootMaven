package com.untils.framework;

import org.apache.logging.log4j.LogManager;

/**
 * 日志公用类
 * Created by hefule on 2016/8/2.
 */
public class LoggerInfo<T> {
    protected final static RedisUtil redisUtil = new RedisUtil();
    public LoggerInfo(){}
    public LoggerInfo(T t){
        LogManager.getLogger(t.getClass());
    }
}
