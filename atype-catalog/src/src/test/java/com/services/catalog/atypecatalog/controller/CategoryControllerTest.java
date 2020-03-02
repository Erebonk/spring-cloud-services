package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.Category;
import com.services.catalog.atypecatalog.service.catalog.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoryService categoryService;

    @Test
    void shouldReturnAvailCategories() throws Exception {
        given(categoryService.getCategory("d", "2"))
                .willReturn(Optional.of(Collections.singletonList(new Category().setId("1").setName("category"))));

        this.mockMvc.perform(get("/categories?username=d&password=2"))
            .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("category")));
    }

}
