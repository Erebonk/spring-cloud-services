package com.services.catalog.atypecatalog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.io.Serializable;

/**
 * Catalog's price type
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
        name = "findallpricetypes",
        procedureName = "findallpricetypes",
        resultClasses = PriceType.class
)
public class PriceType implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "descr")
    private String name;

}
