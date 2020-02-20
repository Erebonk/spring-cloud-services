package com.services.catalog.atypecatalog.repository;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Price type repository
 *
 * @author ilya
 * @version 1.0
 */
@Repository
public interface PriceTypeRepository extends PagingAndSortingRepository<PriceType, String> {}
