package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.repository.PriceTypeMapper;
import com.services.catalog.atypecatalog.service.catalog.PriceTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Price types services
 *
 * @author ilya
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class PriceTypeServicesImpl implements PriceTypeServices {

    private final PriceTypeMapper priceTypeMapper;

    @Override
    public Optional<List<PriceType>> getPriceTypes() {
        var priceTypes = priceTypeMapper.getPriceTypes();
        return Optional.of(priceTypes);
    }

}
