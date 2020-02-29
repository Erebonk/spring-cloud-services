package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.Product;
import com.services.catalog.atypecatalog.service.catalog.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Override
    public Optional<List<Product>> getProducts(String categoryId, String priceType, String username, String password) {
        return Optional.empty();
    }

}
