package com.blog.controller;

import com.blog.bean.Blog;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    BlogService blogService;

    @RequestMapping("/index.do")
    public String index(Model model){
        List<Blog> blogsTop5 = blogService.queryTop5Blog();
        List<Blog> blogsTop10 = blogService.queryTop10Blog();
        model.addAttribute("popularBlogs",blogsTop5);
        model.addAttribute("bolgList",blogsTop10);
        return "index.html";
    }

    @RequestMapping("/title.do")
    public String title(Model model){
        Long id = (Long) model.getAttribute("title");
        blogService.updateBlogPageView(id);
        Blog blog = blogService.queryBlogById(id);
        model.addAttribute("blog",blog);
        return "bloglist.html";
    }
}
