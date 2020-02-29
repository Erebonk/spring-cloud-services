package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from findallproducts(#{category_pattern, mode=IN, jdbcType=VARCHAR})")
    List<Product> findAllByCategory(@Param("category_pattern") String category);

}
