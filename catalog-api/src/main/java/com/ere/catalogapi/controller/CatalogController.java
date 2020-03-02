package com.ere.catalogapi.controller;

import com.ere.catalogapi.service.AtypeProxyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final AtypeProxyService atypeProxyService;

    @GetMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "defaultCatList")
    public Object getPriceTypes() {
        return atypeProxyService.getPriceTypes();
    }

    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "categoriesError")
    @GetMapping("/categories")
    public Object getCategories(@RequestParam String priceTypes) {
        return atypeProxyService.getCategories(priceTypes);
    }


    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "productsError")
    @GetMapping("/products")
    public Object getProducts(@RequestParam String priceTypes,
                              @RequestParam String category) {
        return atypeProxyService.getProducts(priceTypes, category);

    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String productsError() {
        return "Problem with products method";
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String categoriesError() {
        return "Problem with categories service...";
    }

    public List<String> defaultCatList() {
        return new ArrayList<>() {{
            add("All");
            add("Avail");
        }};
    }

}
