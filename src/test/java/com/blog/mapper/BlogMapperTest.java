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
        System.out.println(blogMapper.selectAllStudent());
    }

    public void testSelectTop5Student() {
        System.out.println(blogMapper.selectTop5Student());
    }

    public void testSelectTop10Student() {
        System.out.println(blogMapper.selectTop10Student());

    }

    public void testSelectTimeSequenceStudent() {
        System.out.println(blogMapper.selectTimeSequenceStudent());
    }

    public void testSelectStudentById() {
        System.out.println(blogMapper.selectStudentById(2l));
    }

    public void testSelectStudentByAccountId() {
        System.out.println(blogMapper.selectStudentByAccountId(2l));
    }

    public void testSelectStudentByKind() {
        System.out.println(blogMapper.selectStudentByKind("dsa"));
    }

    public void testInsertBlog() {
        blogMapper.insertBlog(new Blog("title","kind","schema","content",accountMapper.selectById(2l),new Timestamp(System.currentTimeMillis())));
    }

    public void testDeleteBolg() {
        System.out.println(blogMapper.deleteBolg(2l));
    }

    public void testUpdateBlog() {
        blogMapper.updateBlog(new Blog(3l,"title","kind","schema","content",accountMapper.selectById(2l),new Timestamp(System.currentTimeMillis())));
    }
}