package com.ere.catalogapi.service;

import com.ere.catalogapi.controller.FallbackController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "atype-service", fallback = FallbackController.class)
public interface AtypeProxyService {

    @GetMapping("types")
    ResponseEntity<?> getPriceTypes();

    @GetMapping("categories")
    ResponseEntity<?> getCategories(@RequestParam("username") String priceType, @RequestParam("password") String password);

    @GetMapping("products")
    ResponseEntity<?> getProducts(@RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("priceType") String priceType, @RequestParam("categoryId") String categoryId);

}
