package com.service.demo;

import com.mapper.demo.DemoMapper;
import com.model.demo.Demo;
import com.untils.framework.LoggerInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefule on 2016/7/31.
 */
@Service("demoService")
public class DemoService extends LoggerInfo<DemoService> {

    @Resource(name = "demoMapper")
    private DemoMapper userMapper;

    /**
     *  自定义缓存
     *  @author hefule
     *  @date 2016/8/2 16:26
     *
     */
    public List<Demo> findUserInfo() throws Exception {
        return userMapper.loadModeForAll(new Demo());
    }

    /**
     * 需要需要用到缓存时标记就好，
     * 查增时候使用  @Cacheable
     * 当是改的时候 @CachePut
     * 如果需要删除时候用@CacheEvict 属性allEntries为true时清空所有
     *@author hefule
     *@date 2016/8/2 15:09
     *  属性说明：value为缓存组，key为缓存key, wiselyKeyGenerator缓存策略（有key则不用）
     */
    @Cacheable(value="userCache",key = "#bs")
    public List<Demo> getUserInfo(String bs) throws Exception {
        System.out.println("无缓存的时候调用这里---数据库查询");
        /*return userMapper.loadModeForAll(new Demo());*/
        return new ArrayList<Demo>(6);
    }
}
