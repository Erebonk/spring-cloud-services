package com.services.catalog.atypecatalog.service.catalog;

import com.services.catalog.atypecatalog.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<Category>> getCategory(String username, String password);
}
