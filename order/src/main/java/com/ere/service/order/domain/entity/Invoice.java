package com.ere.service.order.domain.entity;

import com.ere.service.order.domain.InvoiceStatus;
import com.ere.service.order.domain.external.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document
public class Invoice extends BaseEntity {

    @Id
    private String id;

    private String customerId;

    private List<Order> orders = new ArrayList<>();

    private Address billingAddress;

    private InvoiceStatus invoiceStatus;

    public Invoice(String customerId, List<Order> orders,
                   Address billingAddress, InvoiceStatus invoiceStatus) {
        this.customerId = customerId;
        this.orders = orders;
        this.billingAddress = billingAddress;
        this.invoiceStatus = invoiceStatus;
    }

    public Invoice(String accountNumber, Address billingAddress) {
        this.customerId = accountNumber;
        this.billingAddress = billingAddress;
    }

    public void addOrder(Order order) {
        order.setAccountNumber(this.customerId);
        orders.add(order);
    }
}
