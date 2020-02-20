package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.repository.PriceTypeRepository;
import com.services.catalog.atypecatalog.service.catalog.PriceTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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

    private final PriceTypeRepository priceTypeRepository;
    private final EntityManager entityManager;

    @Override
    public Optional<List<PriceType>> getPriceTypes() {
        var procedure = entityManager.createNamedStoredProcedureQuery("findallpricetypes");
        var result = (List<PriceType>) procedure.getResultList();
        return Optional.of(result);
    }

}
