package com.blog.service;

import com.blog.bean.Account;
import com.blog.bean.Blog;
import com.blog.bean.Kind;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.KindMapper;
import com.blog.util.StringUtil;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class BlogService {

    @Resource
    private BlogMapper mapper;

    @Resource
    private KindMapper kindMapper;

    /**
     * 查询所有blog
     * @return 返回全部blog
     */
    public List<Blog> queryAllBlog(){
        return mapper.selectAllBlog();
    }

    /**
     * 查询所有分类
     * @return 返回全部分类
     */
    public List<Kind> queryAllKind(){
        return kindMapper.selectKind();
    }

    /**
     *查询热度前五的blog
     * @return 返回热度前五的blog
     */
    public List<Blog> queryTop5Blog(){
        return mapper.selectTop5Blog();
    }

    /**
     * 查询创建时间前十的blog
     * @return 返回创建时间前5的blog
     */
    public List<Blog> queryTop10Blog(){
        return mapper.selectTop10Blog();
    }

    /**
     * 查询时间倒序blog
     * @return 时间倒序blog
     */
    public List<Blog> queryTimeSequenceBlog(){
        return mapper.selectTimeSequenceBlog();
    }

    /**
     * 通过id获取博客内容
     * @param id 博客id
     * @return 单个博客的内容
     */
    public Blog queryBlogById(Long id){
        return mapper.selectBlogById(id);
    }

    /**
     * 通过账户id获取博客内容
     * @param AccountId 账户id
     * @return 某个用户的博客的内容
     */
    public List<Blog> queryBlogByAccountId(Long AccountId){
        return mapper.selectStudentByAccountId(AccountId);
    }

    /**
     * 通过博客分类获取博客内容
     * @param kind 博客分类
     * @return 某个分类的博客的内容
     */
    public List<Blog> queryBlogByKind(String kind){
        return mapper.selectStudentByKind(kind);
    }

    /**
     * 添加blog
     * @param id id
     * @param title 标题
     * @param kind 分类
     * @param schema 简介
     * @param content 内容
     * @return 是否添加成功
     */
    public boolean insertBlog(Long id, String title, String kind, String schema, String content){
        Account account = new Account();
        account.setId(id);
        return mapper.insertBlog(new Blog(title,kind,schema,content,account,new Timestamp(System.currentTimeMillis()), 0L))>0;
    }

    /**
     * 删除指定id的blog
     * @param id 指定id
     * @return 是否删除成功
     */
    public boolean deleteBolg(Long id){
        return mapper.deleteBolg(id)>0;
    }

    /**
     * 更新博客
     * @param id 博客id
     * @param kind 博客分类
     * @param schema 博客简介
     * @param content 博客内容
     * @return 是否更新成功
     */
    public boolean updateBlog(Long id,String kind,String schema,String content){
        Blog blog = queryBlogById(id);
        if (blog!=null){
            if (StringUtil.checkString(schema)){
                blog.setSchema(schema);
            }
            if (StringUtil.checkString(kind)){
                blog.setKind(kind);
            }
            if (StringUtil.checkString(content)){
                blog.setContent(content);
            }
            return mapper.updateBlog(blog)>0;
        }
        return false;
    }

    /**
     * 更新博客的浏览量
     * @param id 博客id
     * @return 是否新增成功
     */
    public boolean updateBlogPageView(Long id){
        Blog blog = queryBlogById(id);
        if (blog!=null){
            if (blog.getPageView()==null){
                blog.setPageView(1L);
            }else {
                blog.setPageView(blog.getPageView()+1);
            }
            return mapper.updateBlogPageView(blog)>0;
        }
        return false;
    }

}
