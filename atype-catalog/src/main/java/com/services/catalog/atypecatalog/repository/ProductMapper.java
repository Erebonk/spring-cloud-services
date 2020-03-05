package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select(value = "select * from findproducts(#{category_pattern, mode=IN, jdbcType=VARCHAR})")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "descr", property = "name"),
            @Result(column = "partnumber", property = "partnumber"),
            @Result(column = "pricen", property = "price"),
            @Result(column = "stock_main", property = "amountOnStock"),
            @Result(column = "stock_far", property = "amountFarStock"),
            @Result(column = "category", property = "category")
    })
    @Options(statementType = StatementType.CALLABLE)
    List<Product> findAllByCategory(@Param("category_pattern") String category);

}
