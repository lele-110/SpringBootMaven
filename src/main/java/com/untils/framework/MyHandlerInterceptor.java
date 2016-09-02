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
import java.util.Locale;

/**
 * 定义拦截器
 * Created by hefule on 2016/8/7 21:47.
 */
@Configuration
public class MyHandlerInterceptor extends WebMvcConfigurerAdapter {
    private Logger logger = LogManager.getLogger(MyHandlerInterceptor.class);

    @Resource(name="redisUtil")
    protected RedisUtil redisUtil;

    //设置切换语言的功能
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }
   //设置切换语言的功能
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

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
                    writeObject(request,"realPath",true);
                    writeObject(request,"basePath",false);
               }catch (Exception e){
                   logger.error(e.getMessage(),e.getCause());
                   throw e;
               }
                return true;
            }
        },localeChangeInterceptor()).addPathPatterns("/**");
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

    /**
     *  获取项目路径
     *  @author hefule
     *  @date 2016/8/8 2:00
     *  @param request
     *  @Param name 名稱
     *  @param isPort 是否包含項目之前的路徑
     */
    private void writeObject(HttpServletRequest request,String name,boolean isPort) throws Exception {
        String path = ObjectUtils.basePath(request,isPort);
        if(!path.equals(redisUtil.loadObject(name)))
            redisUtil.writeObject(name, path);
    }

}
