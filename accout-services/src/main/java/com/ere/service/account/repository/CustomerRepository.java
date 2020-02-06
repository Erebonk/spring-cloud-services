package com.ere.service.account.repository;

import com.ere.service.account.domain.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Customer repository
 *
 * @author ilya
 * @version 1.0
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Optional<Customer> findByEmailContaining(String email);
}
