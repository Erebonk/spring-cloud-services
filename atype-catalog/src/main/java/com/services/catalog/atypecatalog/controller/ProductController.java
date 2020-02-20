package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.Product;
import com.services.catalog.atypecatalog.domain.exception.ProductReqException;
import com.services.catalog.atypecatalog.service.catalog.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Product controller for products
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProductByCategory(@RequestParam String username, @RequestParam String password,
                                              @RequestParam String categoryId, @RequestParam String catalogType) {
        return productService.getProducts(categoryId, catalogType, username, password)
                .orElseThrow(() -> new ProductReqException("There aren't avail products"));
    }



}
