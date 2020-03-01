package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.domain.entity.Product;
import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import com.services.catalog.atypecatalog.service.catalog.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductServiceImpl productService;

    @Test
    void shouldReturnAvailProducts() throws Exception {
        given(productService.getProducts("null", "null", "null","null"))
                .willReturn(Optional.of(Collections.singletonList(new Product().setId("id").setName("hp"))));

        this.mockMvc.perform(get("/products?username=null&password=null&categoryId=null&catalogType=null"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id")));
    }

}