package com.blog.service;

import com.blog.config.SpringMVCConfig;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogServiceTest extends TestCase {

    BlogService blogService=(BlogService) new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("blogService");

    public void testQueryAllBlog() {
        System.out.println(blogService.queryAllBlog());
    }

    public void testQueryTop5Blog() {
        System.out.println(blogService.queryTop5Blog());
    }

    public void testQueryTop10Blog() {
        System.out.println(blogService.queryTop10Blog());
    }

    public void testQueryTimeSequenceBlog() {
        System.out.println(blogService.queryTimeSequenceBlog());
    }

    public void testQueryBlogById() {
        System.out.println(blogService.queryBlogById(3L));
    }

    public void testQueryBlogByAccountId() {
        System.out.println(blogService.queryBlogByAccountId(2L));
    }

    public void testQueryBlogByKind() {
        System.out.println(blogService.queryBlogByKind("das"));
    }

//    public void testInsertBlog() {
//        System.out.println(blogService.insertBlog(2L,"这是标题1","这是分类1","这是简介1","这是内容1" ));
//    }

    public void testDeleteBolg() {
        System.out.println(blogService.deleteBolg(7L));
    }

    public void testUpdateBlog() {
        System.out.println(blogService.updateBlog(3L,"测试1","这是标题1","这是内容1 "));
    }

    public void testUpdateBlogPageView() {
        System.out.println(blogService.updateBlogPageView(7L));
    }
}