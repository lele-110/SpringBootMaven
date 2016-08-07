package com.untils.framework;

import com.untils.object.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义拦截器
 * Created by hefule on 2016/8/7 21:47.
 */
@Configuration
public class MyHandlerInterceptor extends WebMvcConfigurerAdapter {
    private Logger logger = LogManager.getLogger(MyHandlerInterceptor.class);

    @Resource(name="redisUtil")
    protected RedisUtil redisUtil;
    /**
     *  拦截器
     *  @author hefule
     *  @date 2016/8/7 22:17
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                     Object handler) throws Exception {
               try{
                    String basePath = ObjectUtils.basePath(request);
                    if(!basePath.equals(redisUtil.loadObject("basePath")))
                        redisUtil.writeObject("basePath", ObjectUtils.basePath(request));
               }catch (Exception e){
                   logger.error(e.getMessage(),e.getCause());
                   throw e;
               }
                return true;
            }
        }).addPathPatterns("/**");
    }

    /**
     *  过滤静态文件
     *  @author hefule
     *  @date 2016/8/8 0:51
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
