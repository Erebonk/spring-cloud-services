package com.ere.services.searcher.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Product controller test
 *
 * @author ilya
 * @version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void searchShouldReturnAllAvailProducts_IfHp() {
        var products = testRestTemplate.getForEntity("/products/search" + "?text=hp", Object.class);
        assertNotNull(products);
    }


}