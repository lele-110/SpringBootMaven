package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hefule on 2016/7/30.
 */
@Configuration
@EnableAutoConfiguration//启用自动配置
@ComponentScan//组件扫描
public class ApplicationMain extends SpringBootServletInitializer {
    private static Class<ApplicationMain> applicationClass = ApplicationMain.class;
    private Logger logger = LogManager.getLogger(applicationClass);

    /**
     * 打包成war时候需要用到，即指定入口
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }

    /**
     * 只做一件事，启动应用服务器
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(applicationClass,args);
    }
}
