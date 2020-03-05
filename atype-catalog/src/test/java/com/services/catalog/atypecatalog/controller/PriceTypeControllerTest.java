package com.services.catalog.atypecatalog.controller;

import com.services.catalog.atypecatalog.domain.entity.Category;
import com.services.catalog.atypecatalog.domain.entity.PriceType;
import com.services.catalog.atypecatalog.service.catalog.PriceTypeServices;
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
class PriceTypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PriceTypeServices priceTypeServices;

    @Test
    void shouldReturnAvailPriceTypes() throws Exception {
        given(priceTypeServices.getPriceTypes())
                .willReturn(Optional.of(Collections.singletonList(new PriceType(1, "id"))));

        this.mockMvc.perform(get("/types"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id")));
    }

}