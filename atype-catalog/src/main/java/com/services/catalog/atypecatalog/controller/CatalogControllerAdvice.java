package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.exception.CategoryReqException;
import com.services.catalog.atypecatalog.domain.exception.PriceTypeReqException;
import com.services.catalog.atypecatalog.domain.exception.ProductReqException;
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
    @ExceptionHandler(PriceTypeReqException.class)
    private String priceTypeEx(PriceTypeReqException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ProductReqException.class)
    private String productEx(ProductReqException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(CategoryReqException.class)
    private String categoriesEx(CategoryReqException ex) {
        return ex.getMessage();
    }

}
