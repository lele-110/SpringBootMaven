package com.untils.framework;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据源，在初始化完成之后会生成sqlSessionFactoryBean注入到mybatis
 * Created by hefule on 2016/7/31.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.mapper")
public class DataBaseConfig extends LoggerInfo<DataBaseConfig>{

    @Autowired
    private Environment env;

    //DataSource配置
    @Bean(name = "baseDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource baseDataSource() throws Exception {
        return  new org.apache.tomcat.jdbc.pool.DataSource();
    }

    private DataSource loadDateSource() throws Exception {
        DataSource dataSource = baseDataSource();
        if(dataSource.getConnection()==null) throw new Exception("数据库连接错误");
        return dataSource;
    }
    //提供SqlSeesion
    @Bean(name="sqlSessionFactoryBean")
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        /*从配置文件中获取属性*/
       // System.out.println(env.getProperty("spring.datasource.url"));
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(loadDateSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(loadDateSource());

    }

    @Bean(name="SqlSessionBean")
    @Primary
    public SqlSession SqlSessionBean() throws Exception {
       return sqlSessionFactoryBean().openSession();
    }
}
