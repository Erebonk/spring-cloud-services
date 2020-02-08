package com.ere.service.order.domain.entity;

import com.ere.service.order.domain.OrderStatus;
import com.ere.service.order.domain.external.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {

    @Id
    private String orderId;

    private String accountNumber;

    private OrderStatus orderStatus;

    private List<LineItem> lineItems = new ArrayList<>();

    private Address shippedAddress;

    public Order(String accountNumber, OrderStatus orderStatus,
                 List<LineItem> lineItems, Address shippedAddress) {
        this.accountNumber = accountNumber;
        this.orderStatus = orderStatus;
        this.lineItems = lineItems;
        this.shippedAddress = shippedAddress;
    }

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
}
