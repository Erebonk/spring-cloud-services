package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Category repository
 *
 * @author ilya
 * @version 1.0
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {}
