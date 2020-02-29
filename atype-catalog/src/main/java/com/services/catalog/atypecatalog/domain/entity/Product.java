package com.services.catalog.atypecatalog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product entities
 *
 * @author ilya
 * @version 1.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product implements Serializable {

    private String id;

    private String name;

    private BigDecimal price;

    private String vendorCode;

    private String amountOnStock;

    private String amountFarStock;

    private String category;

}
