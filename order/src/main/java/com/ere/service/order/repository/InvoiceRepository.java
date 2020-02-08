package com.ere.service.order.repository;

import com.ere.service.order.domain.entity.Invoice;
import com.ere.service.order.domain.external.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, String> {

    Invoice findByBillingAddress(Address billingAddress);
}
