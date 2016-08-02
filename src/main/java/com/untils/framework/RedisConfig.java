package com.untils.framework;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis基础配置,在初始化完成之后会生成wiselyKeyGenerator bean
 * Created by hefule on 2016/8/2.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 返回一个springBoot框架缓存对象
     *@author hefule
     *@date 2016/8/2 14:28
     *
     */
    @Bean(name = "wiselyKeyGenerator")
    public KeyGenerator wiselyKeyGenerator(){
        //lambda表达式
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };

    }

    /**
     * 返回缓存管理对象-redis
     *@author hefule
     *@date 2016/8/2 14:29
     * @param redisTemplate 通过下面的 redisTemplate（）方法注入
     */
    @Bean(name = "cacheManager")
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    /**
     *  redis对象设置
     *@author hefule
     *@date 2016/8/2 14:33
     * @param redisConnectionFactory 通过下面的 redisConnectionFactory（）方法注入
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     *  redis数据源
     *@author hefule
     *@date 2016/8/2 14:47
     *
     */
    @Bean(name = "redisConnectionFactory")
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisConnectionFactory redisConnectionFactory(){
       return new JedisConnectionFactory();
    }
}
