package com.ere.catalogapi.controller;

import com.ere.catalogapi.service.AtypeProxyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FallbackController implements AtypeProxyService {

    @Override
    public ResponseEntity<?> getPriceTypes() {
        return ResponseEntity.badRequest().body("bad");
    }

    @Override
    public ResponseEntity<?> getCategories(String priceType, String password) {
        return ResponseEntity.badRequest().body("bad");
    }

    @Override
    public ResponseEntity<?> getProducts(String username, String password, String priceType, String categoryId) {
        return ResponseEntity.badRequest().body("bad");
    }
}
