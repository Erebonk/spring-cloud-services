package com.ere.catalogapi.controller;

import com.ere.catalogapi.service.AtypeProxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final AtypeProxyService atypeProxyService;

    @GetMapping("/types")
    public ResponseEntity<?> getPriceTypes() {
        return atypeProxyService.getPriceTypes();
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return atypeProxyService.getCategories("null","null");
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(@RequestParam String priceTypes,
                              @RequestParam String category) {
        return atypeProxyService.getProducts("null", "null", priceTypes, category);

    }

}
