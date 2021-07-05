package com.blog.controller;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.mapper.KindMapper;
import com.blog.service.AccountService;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/kind.do")//加载指定类型博客
    public String kind(String kind,Model model){
        List<Blog> blogs = blogService.queryBlogByKind(kind);
        model.addAttribute("kind1",kind);
        model.addAttribute("blogs",blogs);
        return "blogkind.html";
    }

    @RequestMapping("/deleteBlog.do")//删除指定博客
    public String deleteBlog(Long id){
        blogService.deleteBolg(id);
        return "redirect:myBlog.do";
    }

    @RequestMapping("/viewmodifyblog.do")//显示修改博客页面
    public String viewModifyBlog(Long id,Model model,HttpSession session){
        Account account = (Account) session.getAttribute("account");
        if (account!=null) {
            model.addAttribute("kinds", kindMapper.selectKind());
            model.addAttribute("id",id);
            return "blogmodify.html";

        }
        return "redirect:index.do";
    }

    @RequestMapping("/modifyblog.do")//修改博客页面
    public String modifyBlog(Long id,String kind,String schema,String content){
        blogService.updateBlog(id,kind,schema,content);
        return "redirect:myBlog.do";
    }


    @RequestMapping("/title.do")//按照标题加载blog
    public String title(Long title,Model model){
        blogService.updateBlogPageView(title);
        Blog blog = blogService.queryBlogById(title);
        model.addAttribute("blog",blog);
        return "bloginfo.html";
    }

    @RequestMapping("/blog.do")//加载所有用户
    public String blog(Model model){

        List<Blog> blogs = blogService.queryAllBlog();
        model.addAttribute("blogs",blogs);
        return "bloglist.html";
    }

    @RequestMapping("/createBlog.do")//接受创建博客参数，并存入数据库
    public String creatBlog(String title,String kind,String schema,String  content, HttpSession session){
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            blogService.insertBlog(account.getId(),title,kind,schema,content);
            return "redirect:myBlog.do";
        }else {
            return "blogcreate.html";
        }
    }

    @RequestMapping("/viewCreateBlog.do")//加载博客添加页面
    public String viewCreatBlog(Model model, HttpSession session){
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            model.addAttribute("kinds",kindMapper.selectKind());
            return "blogcreate.html";
        }
        return "login.html";
    }


}
