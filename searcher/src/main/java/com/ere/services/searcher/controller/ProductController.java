package com.ere.services.searcher.controller;

import com.ere.services.searcher.config.ElasticProductServicesProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Product controller
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ElasticProductServicesProxy elasticProductServicesProxy;

    @GetMapping("/search")
    public Object search(@NotNull @RequestParam String text) {
        return elasticProductServicesProxy.searchProduct(text);
    }

}
