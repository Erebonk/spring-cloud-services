package com.ere.service.account.domain.entity;

import com.ere.service.account.domain.CreditCardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    public CreditCard(String number, CreditCardType creditCardType) {
        this.number = number;
        this.creditCardType = creditCardType;
    }
}
