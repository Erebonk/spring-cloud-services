package com.ere.services.searcher.config;

import com.ere.services.searcher.controller.ProductController;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RibbonClient(name = "elastic-service")
@FeignClient(name = "elastic-service")
public interface ElasticProductServicesProxy {

    @ResponseBody
    @GetMapping("products/search")
    Object searchProduct(@RequestParam String text);

}
