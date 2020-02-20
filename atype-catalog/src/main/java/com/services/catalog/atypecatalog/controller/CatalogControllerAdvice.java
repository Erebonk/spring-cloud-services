package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.exception.PriceTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Catalog controller advice
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@ControllerAdvice
public class CatalogControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(PriceTypeException.class)
    private String priceTypeEx(PriceTypeException ex) {
        return ex.getMessage();
    }

}
