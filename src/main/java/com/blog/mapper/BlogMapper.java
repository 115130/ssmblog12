package com.blog.mapper;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BlogMapper {
    @Select("select * from blog")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectAllStudent();

    @Select("select * from blog order by pageView desc limit 0,5")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectTop5Student();

    @Select("select * from blog order by creationTime desc limit 0,10")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectTop10Student();
    @Select("select * from blog order by creationTime desc,modification desc")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectTimeSequenceStudent();
    @Select("select * from blog where id=#{xxx}")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    Blog selectStudentById(Long id);
    @Select("select * from blog where author=#{xxx}")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectStudentByAccountId(Long AccountId);
    @Select("select * from blog where kind=#{xxx}")
    @Results({
            @Result(column = "author" ,property = "author",one=@One(select = "com.blog.mapper.AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    List<Blog> selectStudentByKind(String kind);


    @Insert("insert into blog (title,kind,`schema`,author,creationtime,content) values (#{title},#{kind},#{schema},#{author.id},#{creationTime},#{content})")
    int insertBlog(Blog blog);

    @Delete("delete from blog where id=#{xxx}")
    int deleteBolg(Long id);

    @Update("update blog set title=#{title},kind=#{kind},`schema`=#{schema},content=#{content} where id=#{id}")
    int updateBlog(Blog blog);

}
