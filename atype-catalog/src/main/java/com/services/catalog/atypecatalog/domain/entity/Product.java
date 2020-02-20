package com.services.catalog.atypecatalog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product entities
 *
 * @author ilya
 * @version 1.0
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@NamedStoredProcedureQuery(
        name = "findallproducts",
        procedureName = "findallproducts",
        resultClasses = Product.class,
        parameters = {
                @StoredProcedureParameter(
                        name = "priceType",
                        type = String.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "username",
                        type = String.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "password",
                        type = String.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "categoryId",
                        type = String.class,
                        mode = ParameterMode.IN
                )
        }
)
public class Product implements Serializable {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @Column(name = "descr")
    private String name;

    @Column(name = "priceN")
    private BigDecimal price;

    @Column(name = "partnumber")
    private String vendorCode;

    @Column(name = "stock_main")
    private String amountOnStock;

    @Column(name = "stock_far")
    private String amountFarStock;


}
