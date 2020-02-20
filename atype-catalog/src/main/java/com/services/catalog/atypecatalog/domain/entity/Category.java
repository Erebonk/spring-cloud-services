package com.services.catalog.atypecatalog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Product's category
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
        name = "findallcategories",
        procedureName = "findallcategories",
        resultClasses = Category.class,
        parameters = {
                @StoredProcedureParameter(
                        name = "username",
                        type = String.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "password",
                        type = String.class,
                        mode = ParameterMode.IN
                )
        }
)
public class Category implements Serializable {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @Column(name = "name")
    private String name;

}
