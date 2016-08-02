package com.untils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源
 * Created by hefule on 2016/7/31.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.mapper")
public class DataBaseConfig {
    private final Logger log = LogManager.getLogger(DataBaseConfig.class);
    @Autowired
    private Environment env;

    //DataSource配置
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource baseDataSource(){
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
    //提供SqlSeesion
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        /*从配置文件中获取属性*/
        System.out.println(env.getProperty("spring.datasource.url"));
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(baseDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(baseDataSource());
    }
}
