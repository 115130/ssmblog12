package com.blog.mapper;

import com.blog.bean.Kind;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KindMapper {
    @Select("select * from kind")
    List<Kind> selectKind();
}
