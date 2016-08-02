package com.service.demo;

import com.mapper.demo.DemoMapper;
import com.model.demo.Demo;
import com.untils.framework.LoggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by hefule on 2016/7/31.
 */
@Service("demoService")
public class DemoService extends LoggerInfo<DemoService> {

    @Autowired
    private DemoMapper userMapper;

    /**
     *  自定义缓存
     *  @author hefule
     *  @date 2016/8/2 16:26
     *
     */
    public Demo findUserInfo() throws Exception {
        return userMapper.findUserInfo();
    }

    /**
     *需要需要用到缓存时标记就好
     *@author hefule
     *@date 2016/8/2 15:09
     *
     */
    @Cacheable(value = "userCache", keyGenerator = "wiselyKeyGenerator")
    public Demo getUserInfo() throws Exception {
        System.out.println("无缓存的时候调用这里---数据库查询");
        return userMapper.findUserInfo();
    }
}
