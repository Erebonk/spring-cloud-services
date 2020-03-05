package com.services.catalog.atypecatalog.service.catalog.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    void shouldReturnAllAvailProduct() {
        var products = productService.getProducts(null, null, null, null);
        assertTrue(products.isPresent());
        products.get().forEach(product -> {
            assertNotNull(product.getId());
            assertNotNull(product.getName());
            assertNotNull(product.getPrice());
        });
    }


    @Test
    void shouldReturnAvailProductByCategory() {
        var products = productService.getProducts("cat", null, null, null);
        assertTrue(products.isPresent());
        products.get().forEach(product -> {
            assertNotNull(product.getId());
            assertNotNull(product.getName());
            assertNotNull(product.getPrice());
        });
    }

}