package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.domain.exception.PriceTypeReqException;
import com.services.catalog.atypecatalog.service.catalog.PriceTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Price type controller
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class PriceTypeController {

    private final PriceTypeServices priceTypeServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PriceType> getPriceType() {
        return priceTypeServices.getPriceTypes()
                .orElseThrow(() -> new PriceTypeReqException("There aren't avail categories"));
    }

}
