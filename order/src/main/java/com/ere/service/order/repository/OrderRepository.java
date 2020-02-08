package com.ere.service.order.repository;

import com.ere.service.order.domain.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {}
