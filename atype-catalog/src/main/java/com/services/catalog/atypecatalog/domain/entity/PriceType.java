package com.services.catalog.atypecatalog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Catalog's price type
 *
 * @author ilya
 * @version 1.0
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class PriceType implements Serializable {

    private Integer id;

    private String name;

}
