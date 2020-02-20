package com.services.catalog.atypecatalog.config;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.repository.CategoryRepository;
import com.services.catalog.atypecatalog.repository.PriceTypeRepository;
import com.services.catalog.atypecatalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

@Profile("dev")
@Configuration
@AutoConfigureAfter({
        CategoryRepository.class,
        ProductRepository.class,
        PriceTypeRepository.class})
@RequiredArgsConstructor
public class CatalogInit {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceTypeRepository priceTypeRepository;

    @Bean
    public void initCatalog() {
        priceTypeRepository.saveAll(new ArrayList<>() {{
            add(new PriceType().setId("1").setName("All"));
            add(new PriceType().setId("2").setName("New"));
            add(new PriceType().setId("3").setName("Sale"));
            add(new PriceType().setId("4").setName("Bad"));
        }});
    }

}
