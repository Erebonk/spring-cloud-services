package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.Product;
import com.services.catalog.atypecatalog.service.catalog.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final EntityManager entityManager;

    @Override
    public Optional<List<Product>> getProducts(String categoryId, String priceType, String username, String password) {
       var procedure = entityManager.createNamedStoredProcedureQuery("findallproducts");
       procedure.setParameter("pricetype", priceType);
       procedure.setParameter("categoryId", categoryId);
       procedure.setParameter("username", username);
       procedure.setParameter("password", password);
       return Optional.of((ArrayList<Product>) procedure.getResultList());
    }

}
