package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.service.catalog.PriceTypeServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceTypeServicesImplTest {

    @Autowired
    PriceTypeServices priceTypeServices;

    @Test
    void shouldReturnAvailPriceTypes() {
        var availTypes = priceTypeServices.getPriceTypes();
        assertTrue(availTypes.isPresent());

        var availTypesList = availTypes.get();
        assertNotNull(availTypesList);
        assertFalse(availTypesList.isEmpty());

        availTypesList.forEach(types -> {
            assertNotNull(types.getId());
            assertNotNull(types.getName());
        });
    }

}