package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.Category;
import com.services.catalog.atypecatalog.repository.CategoryMapper;
import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Category services
 *
 * @author ilya
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public Optional<List<Category>> getCategory(String username, String password) {
        return Optional.of(categoryMapper.getAllCategories());
    }

}
