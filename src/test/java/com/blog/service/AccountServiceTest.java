package com.blog.service;

import com.blog.bean.Blog;
import com.blog.config.SpringMVCConfig;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountServiceTest extends TestCase {
    AccountService accountService=(AccountService) new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("accountService");


    public void testQueryAllAccount() {
        System.out.println(accountService.queryAllAccount());
    }

    public void testQueryOneAccountById() {
        System.out.println(accountService.queryOneAccountById(2L));
    }

    public void testQueryOneAccountByName() {
        System.out.println(accountService.queryOneAccountByName("test"));
    }

    public void testCheckUserNameAndPassword() {
        System.out.println(accountService.checkUserNameAndPassword("test","test"));
    }

    public void testQueryUserNameById() {
        System.out.println(accountService.queryUserNameById(2L));
    }

    public void testAddAccount() {
        System.out.println(accountService.addAccount("测试","测试",12,1,"test","12345678"));
    }

    public void testUpdateAccount() {
        System.out.println(accountService.updateAccount(2L,"更改测试","12345678",12,1,"test"));
    }

    public void testDeleteAccount() {
        accountService.deleteAccount(3l);
    }
}