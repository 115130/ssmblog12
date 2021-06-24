package com.blog.controller;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.service.AccountService;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RegisterController {
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

    @RequestMapping("/register.do")
    public String register(Account account){
        if (accountService.addAccount(account.getUsername(),account.getPassword(),account.getAge(),account.getGender(),account.getAddress(),account.getTelephone())){
            return "login.html";
        }else {
            return "regist.html";
        }
    }
}
