package com.blog.controller;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.service.AccountService;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyBlogController {
    @Resource
    BlogService blogService;

    @Resource
    AccountService accountService;

    @RequestMapping("/myBlog.do")
    public String myBlog(Model model, HttpSession session){//加载主页页面
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            List<Blog> blogs = blogService.queryBlogByAccountId(account.getId());
            model.addAttribute("myBlog",blogs);
            model.addAttribute("myAccount",account);
            return "personblogschemalist.html";
        }
        return "login.html";
    }
}
