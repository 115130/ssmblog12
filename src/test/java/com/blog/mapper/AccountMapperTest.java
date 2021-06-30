package com.blog.mapper;

import com.blog.bean.Account;
import com.blog.config.SpringMVCConfig;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class AccountMapperTest extends TestCase {
    AccountMapper accountMapper= (AccountMapper) new AnnotationConfigApplicationContext(SpringMVCConfig.class).getBean("accountMapper");

    public void testSelectAllStudent() {
        System.out.println(accountMapper.selectAllStudent());
    }

    public void testSelectById() {
        System.out.println(accountMapper.selectById(1l));
    }

    public void testSelectByName() {
        System.out.println(accountMapper.selectByName("admin"));
    }

    public void testSelectNameById() {
        System.out.println(accountMapper.selectNameById(1l));
    }

    public void testInsertAccount() {
        System.out.println(accountMapper.insertAccount(new Account("test", "test", "test", 1, 1, "test", new Timestamp(System.currentTimeMillis()))));
    }

    public void testUpdateAccount() {
        System.out.println(accountMapper.updateAccount(new Account(1l,"t3est", "tes2t", "test1", 18, 1, "test", new Timestamp(System.currentTimeMillis()))));
    }

    public void testDeleteAccount() {
        System.out.println(accountMapper.deleteAccount(1l));
    }
}