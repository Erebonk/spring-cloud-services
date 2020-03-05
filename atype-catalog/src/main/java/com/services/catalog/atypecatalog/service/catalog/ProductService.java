package com.services.catalog.atypecatalog.service.catalog;


import com.services.catalog.atypecatalog.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getProducts(String categoryId, String priceType, String username, String password);
}
