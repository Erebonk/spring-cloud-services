package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Product repository
 *
 * @author ilya
 * @version 1.0
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {}
