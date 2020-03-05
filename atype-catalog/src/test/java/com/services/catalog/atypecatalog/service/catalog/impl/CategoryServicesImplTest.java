package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServicesImplTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void shouldReturnCategories() {
        var categories = categoryService.getCategory(null, null);
        assertTrue(categories.isPresent());
        categories.get().forEach(category -> {
            assertNotNull(category.getId());
            assertNotNull(category.getName());
        });
    }

}