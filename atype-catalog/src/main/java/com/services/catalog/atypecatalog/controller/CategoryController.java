package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.Category;
import com.services.catalog.atypecatalog.domain.exception.CategoryReqException;
import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Category controller
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> categoryList(@RequestParam String username,
                                       @RequestParam String password) {
        return categoryService.getCategory(username, password)
                .orElseThrow(() -> new CategoryReqException("There aren't avail category."));
    }

}
