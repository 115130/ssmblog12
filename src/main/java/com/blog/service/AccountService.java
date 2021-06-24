package com.blog.service;

import com.blog.bean.Account;
import com.blog.mapper.AccountMapper;
import com.blog.util.StringUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    /**
     * 查询所有用户
     *
     * @return 所有账户
     */
    public List<Account> queryAllAccount() {
        return accountMapper.selectAllStudent();
    }

    /**
     * 查询对应id的账户
     *
     * @param id 账户id
     * @return 返回对应账户
     */
    public Account queryOneAccountById(Long id) {
        return accountMapper.selectById(id);
    }

    /**
     * 获取所有对应姓名的账户
     *
     * @param name 姓名
     * @return 对应姓名的所有账户
     */
    public List<Account> queryOneAccountByName(String name) {
        return accountMapper.selectByName(name);
    }

    /**
     * 验证用户名密码
     * @param name 姓名
     * @param password 密码
     * @return 是否正确
     */
    public boolean checkUserNameAndPassword(String name,String password) {
        List<Account> accounts = accountMapper.selectByName(name);
        if (accounts.size()==0){
            return false;
        }
        for (Account account : accounts) {
            if (account.getUsername().equals(name)&&account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应id的姓名
     *
     * @param id 对应id
     * @return 返回的姓名
     */
    public String queryUserNameById(Long id) {
        return accountMapper.selectNameById(id);
    }

    /**
     *  添加用户
     * @param username 用户名
     * @param password 密码
     * @param age 年龄
     * @param gender 性别
     * @param address 地址
     * @param telephone 电话
     * @return 是否添加成功
     */
    public boolean addAccount(String username, String password, int age, int gender, String address, String telephone) {
        Account account = new Account(username, password, telephone, age, gender, address, new Timestamp(System.currentTimeMillis()));
        return accountMapper.insertAccount(account) > 0;
    }

    /**
     * 修改指定id的用户信息
     * @param id 用户id
     * @param password 密码
     * @param telephone 电话
     * @param age 年龄
     * @param gender 性别
     * @param address 地址
     * @return 是否修改成功
     */
    public boolean updateAccount(Long id, String password, String telephone, int age, int gender, String address) {

        Account account = queryOneAccountById(id);
        if(StringUtil.checkString(password)){
            account.setPassword(password);
        }
        if (StringUtil.checkString(telephone)){
            account.setTelephone(telephone);
        }
        if (StringUtil.checkString(address)){
            account.setAddress(address);
        }
        if (StringUtil.checkInt(age)){
            account.setAge(age);
        }
        if (StringUtil.checkInt(gender)){
            account.setGender(gender);
        }
        return accountMapper.updateAccount(account) > 0;
    }

    /**
     * 删除指定id的用户
     * @param id 要删除人的id
     * @return 返回是否修改成功
     */
    public boolean deleteAccount(Long id) {
        return accountMapper.deleteAccount(id)>0;
    }

}
