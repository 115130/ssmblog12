package com.blog.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;

public class CommonMapperUtil<E> {
    public E getObjectDao(Class<E> eClass, SqlSessionFactory sqlSessionFactory){
        MapperFactoryBean<E> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        mapperFactoryBean.setMapperInterface(eClass);
        try {
            return mapperFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
