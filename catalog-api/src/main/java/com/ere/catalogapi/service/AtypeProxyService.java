package com.ere.catalogapi.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "atype-catalog")
@RibbonClient(name = "atype-service")
public interface AtypeProxyService {

    @GetMapping("catalog/types")
    Object getPriceTypes();

    @GetMapping("catalog/category")
    Object getCategories(@RequestParam("priceType") String priceType);

    @GetMapping("catalog/product")
    Object getProducts(@RequestParam("priceType") String priceType, @RequestParam("categoryId") String categoryId);

}
