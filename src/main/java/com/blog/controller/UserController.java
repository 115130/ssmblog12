package com.blog.controller;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.service.AccountService;
import com.blog.service.BlogService;
import com.blog.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class UserController {
    @Resource
    AccountService accountService;

    @ResponseBody
    @RequestMapping("/checkUserNameExist.do")
    public String checkUserNameExist(String userName){
        List<Account> accounts = accountService.queryOneAccountByName(userName);
        if (accounts.size()==0){
            return "false";
        }
        return "true";
    }

    

    @RequestMapping("/loadUser.do")
    public String  loadUser(Model model){
        List<Account> accounts = accountService.queryAllAccount();
        model.addAttribute("accounts",accounts);
        return "userlist.html";
    }

    @RequestMapping("/register.do")
    public String register(String username,String password,int age,int gender,String address,String telephone){

        if (accountService.addAccount(username,password,age,gender,address,telephone)){
            return "login.html";
        }else {
            return "regist.html";
        }
    }

    @RequestMapping("/deleteaccount.do")//删除指定用户
    public String deleteBlog(Long id,Model model){
        accountService.deleteAccount(id);
        return "redirect:loadUser.do";
    }

    @RequestMapping("/quite.do")//加载指定类型博客
    public String quite(HttpSession session){
        session.removeAttribute("account");
        return "redirect:index.do";
    }

    @RequestMapping("/modifyaccount.do")//修改用户页面
    public String modifyAccount(Account account){
        accountService.updateAccount(account.getId(),account.getPassword(),account.getTelephone(),account.getAge(),account.getGender(),account.getAddress());
        return "redirect:loadUser.do";
    }

    @RequestMapping("/viewmodifyaccount.do")//显示修改用户页面
    public String viewModifyAccount(Long id,Model model){
        model.addAttribute("id",id);
        return "redirect:modifyaccount.html";
    }

    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession session){//登录
        if(StringUtil.checkString(username)&&StringUtil.checkString(password)){
            List<Account> accounts = accountService.queryOneAccountByName(username);
            System.out.println(accounts);
            if (accounts.size()==0){
                return "login.html";
            }
            for (Account account : accounts) {
                if ( password.equals(account.getPassword())){
                    byte[] bytes = account.getPassword().getBytes(StandardCharsets.UTF_8);
                    String passwordSHA = StringUtil.toSHA1(bytes);
                    account.setPassword(passwordSHA);
                    session.setAttribute("account",account);//密码sha加密
                    return "redirect:myBlog.do";
                }
            }
        }
        return "login.html";
    }
}
