package com.services.catalog.atypecatalog.service.catalog;

import com.services.catalog.atypecatalog.domain.entity.PriceType;

import java.util.List;
import java.util.Optional;

public interface PriceTypeServices {

    /**
     * Get avail price types
     *
     * @return list with priceTypes
     */
    Optional<List<PriceType>> getPriceTypes();

}
