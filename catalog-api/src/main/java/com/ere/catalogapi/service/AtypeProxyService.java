package com.ere.catalogapi.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "atype-catalog")
@RibbonClient(name = "atype-catalog")
public interface AtypeProxyService {

    @GetMapping("types")
    Object getPriceTypes();

    @GetMapping("categories")
    Object getCategories(@RequestParam("username") String priceType, @RequestParam("password") String password);

    @GetMapping("products")
    Object getProducts(@RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("priceType") String priceType, @RequestParam("categoryId") String categoryId);

}
