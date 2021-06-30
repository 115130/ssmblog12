package com.blog.mapper;

import com.blog.config.SpringMVCConfig;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KindMapperTest extends TestCase {
    KindMapper kindMapper=(KindMapper)new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("kindMapper");
    public void testSelectKind() {
        System.out.println(kindMapper.selectKind());
    }

}