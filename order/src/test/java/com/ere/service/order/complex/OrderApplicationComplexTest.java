package com.ere.service.order.complex;

import com.ere.service.order.domain.entity.Invoice;
import com.ere.service.order.domain.entity.LineItem;
import com.ere.service.order.domain.entity.Order;
import com.ere.service.order.domain.external.Address;
import com.ere.service.order.repository.InvoiceRepository;
import com.ere.service.order.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
public class OrderApplicationComplexTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @BeforeEach
    @AfterEach
    void reset() {
        orderRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    @Test
    void shouldCreateNewOrderAndSave() {
        var shippingAddress = Address.builder()
                .street1("News streaat 16")
                .state("USA")
                .city("WASHINGTON")
                .country("USA")
                .zipCode(15000)
                .build();

        var order = new Order();
        order.setOrderId("order-1");
        order.setShippedAddress(shippingAddress);

        order.addLineItem(LineItem.builder()
                .productId("test-1")
                .name("Jboss panapskosic mp3")
                .price(21.99)
                .tax(.18)
                .build());

        order.addLineItem(LineItem.builder()
                .productId("test-2")
                .name("Nolka 1389")
                .price(14.99)
                .tax(.18)
                .build());

        order = orderRepository.save(order);

        assertNotNull(order.getOrderId());
        assertEquals(order.getLineItems().size(), 2);

        assertNotEquals(order.getLastModify(), order.getCreateAt());
        order = orderRepository.save(order);
        assertNotEquals(order.getLastModify(), order.getCreateAt());

        var billingAddress = Address.builder()
                .street1("Base 15")
                .state("CA")
                .city("San Francisco")
                .country("USA")
                .zipCode(94103)
                .build();

        String accountNumber = "91381731";
        var invoice = new Invoice(accountNumber, billingAddress);
        invoice.addOrder(order);
        invoice = invoiceRepository.save(invoice);

        assertEquals(invoiceRepository.findByBillingAddress(billingAddress), invoice);
    }

}
