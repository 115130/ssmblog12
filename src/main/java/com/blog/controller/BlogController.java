package com.blog.controller;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.mapper.KindMapper;
import com.blog.service.AccountService;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogController {
    @Resource
    BlogService blogService;
    @Resource
    KindMapper kindMapper;

    @RequestMapping("/index.do")
    public String index(Model model){//加载主页页面
        List<Blog> blogsTop5 = blogService.queryTop5Blog();
        List<Blog> blogsTop10 = blogService.queryTop10Blog();
        model.addAttribute("popularBlogs",blogsTop5);
        model.addAttribute("bolgList",blogsTop10);
        return "index.html";
    }


    @RequestMapping("/title.do")//指定id的用户
    public String title(String title,Model model){
        Long id = (Long) model.getAttribute("title");
        blogService.updateBlogPageView(id);
        Blog blog = blogService.queryBlogById(id);
        model.addAttribute("blog",blog);
        return "bloginfo.html";
    }

    @RequestMapping("/blog.do")//加载所有用户
    public String blog(Model model){

        List<Blog> blogs = blogService.queryAllBlog();
        model.addAttribute("blogs",blogs);
        return "bloglist.html";
    }

    @RequestMapping("/createBlog.do")
    public String creatBlog(String title,String kind,String schema,String  content, HttpSession session){
        List<Blog> blogs = blogService.queryAllBlog();
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            blogService.insertBlog(account.getId(),title,kind,schema,content);
            return "redirect:myBlog.do";
        }else {
            return "blogcreate.html";
        }
    }

    @RequestMapping("/viewCreateBlog.do")//加载所有用户
    public String viewCreatBlog(Model model, HttpSession session){
        List<Blog> blogs = blogService.queryAllBlog();
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            model.addAttribute("kinds",kindMapper.selectKind());
            return "blogcreate.html";
        }
        return "login.html";
    }


}
