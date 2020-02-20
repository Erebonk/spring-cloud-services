package com.services.catalog.atypecatalog.service.catalog.impl;

import com.services.catalog.atypecatalog.domain.entity.Category;
import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Category services
 *
 * @author ilya
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryService {

    private final EntityManager entityManager;

    @Override
    public Optional<List<Category>> getCategory(String username, String password) {
       var savedProcedure = entityManager.createNamedStoredProcedureQuery("findallcategories");
       savedProcedure.setParameter("username", username);
       savedProcedure.setParameter("password", password);
       return Optional.of((ArrayList<Category>) savedProcedure.getResultList());
    }

}
