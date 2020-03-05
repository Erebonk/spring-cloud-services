package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from findallcategories()")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "descr")
    })
    List<Category> getAllCategories();
}
