package com.blog.mapper;

import com.blog.bean.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    @Select("select * from account")
    List<Account> selectAllStudent();
    @Select("select * from account where id=#{xxx}")
    Account selectById(Long id);
    @Select("select * from account where username=#{xxx}")
    List<Account> selectByName(String name);
    @Select("select username from account where id=#{xxx}")
    String selectNameById(Long id);

    @Insert("insert into account (username,password,age,gender" +
            ",address,telephone,creationTime) " +
            "values(#{username},#{password},#{age},#{gender}" +
            ",#{address},#{telephone},#{creationTime})")
    int insertAccount(Account account);

    @Update("update account set password=#{password},age=#{age},gender=#{gender}" +
            ",address=#{address},telephone=#{telephone} where id=#{id}")
    int updateAccount(Account account);

    @Delete("delete from account where id=#{xxx}")
    int deleteAccount(Long id);

}
