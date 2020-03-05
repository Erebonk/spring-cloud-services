package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface PriceTypeMapper {

    @Select("select * from findallpricetypes()")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "descr")
    })
    @Options(statementType = StatementType.CALLABLE)
    List<PriceType> getPriceTypes();

}
