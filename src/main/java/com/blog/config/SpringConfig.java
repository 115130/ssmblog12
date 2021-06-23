package com.blog.config;


import com.blog.mapper.AccountMapper;
import com.blog.mapper.BlogMapper;
import com.blog.util.CommonMapperUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.blog")
public class SpringConfig {
    //设置连接池
    @Bean(name = "dataSource")
    public DataSource newDataSource() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
        HikariConfig config = new HikariConfig(properties);
        return new HikariDataSource(config);
    }

    //注册sqlSessionFactory让spring接管
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory newSqlSessionFactoryBean(@Value("#{dataSource}") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        //设置mybatis.xml文件
        Resource mapperLocations = new PathMatchingResourcePatternResolver().getResource("mybatis.xml");
        bean.setConfigLocation(mapperLocations);

        //不使用配置文件配置mybatis
//        org.apache.ibatis.session.Configuration conn = new org.apache.ibatis.session.Configuration();
//        conn.setMapUnderscoreToCamelCase(true);
//        bean.setConfiguration(conn);

        return bean.getObject();
    }

    //注册Mapper动态代理
    @Bean(name = "accountMapper")
    public AccountMapper newAccountMapperFactoryBean(@Value("#{sqlSessionFactory}") SqlSessionFactory sqlSessionFactory) {
        return new CommonMapperUtil<AccountMapper>().getObjectDao(AccountMapper.class,sqlSessionFactory);
    }

    @Bean(name = "blogMapper")
    public BlogMapper newBlogMapperFactoryBean(@Value("#{sqlSessionFactory}") SqlSessionFactory sqlSessionFactory) {
        return new CommonMapperUtil<BlogMapper>().getObjectDao(BlogMapper.class,sqlSessionFactory);
    }
}
