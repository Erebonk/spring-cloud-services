package com.ere.services.searcher.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RibbonClient(name = "elastic-service")
@FeignClient(name = "elastic-service")
public interface ElasticProductServicesProxy {

    @GetMapping("/elasticsearch-service/products/search")
    Object searchProduct(@RequestParam String text);

}
