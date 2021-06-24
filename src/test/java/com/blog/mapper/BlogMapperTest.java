package com.blog.mapper;

import com.blog.bean.Blog;
import com.blog.config.SpringMVCConfig;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;

public class BlogMapperTest extends TestCase {
    BlogMapper blogMapper=(BlogMapper) new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("blogMapper");
    AccountMapper accountMapper= (AccountMapper) new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("accountMapper");

    public void testSelectAllStudent() {
        System.out.println(blogMapper.selectAllBlog());
    }

    public void testSelectTop5Student() {
        System.out.println(blogMapper.selectTop5Blog());
    }

    public void testSelectTop10Student() {
        System.out.println(blogMapper.selectTop10Blog());

    }

    public void testSelectTimeSequenceStudent() {
        System.out.println(blogMapper.selectTimeSequenceBlog());
    }

    public void testSelectStudentById() {
        System.out.println(blogMapper.selectBlogById(2l));
    }

    public void testSelectStudentByAccountId() {
        System.out.println(blogMapper.selectStudentByAccountId(2l));
    }

    public void testSelectStudentByKind() {
        System.out.println(blogMapper.selectStudentByKind("dsa"));
    }



    public void testDeleteBolg() {
        System.out.println(blogMapper.deleteBolg(2l));
    }


}