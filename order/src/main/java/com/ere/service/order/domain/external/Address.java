package com.ere.service.order.domain.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Long id;

    private String street1;

    private String street2;

    private String state;

    private String city;

    private String country;

    private Integer zipCode;

    public Address(String street1, String street2, String state, String city,
                   String country, Integer zipCode) {
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

}
