package com.ere.service.account.controller;

import com.ere.service.account.domain.entity.Customer;
import com.ere.service.account.domain.exception.UserNotFoundException;
import com.ere.service.account.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@NotNull @RequestParam String email) {
        return customerRepository.findByEmailContaining(email)
                .orElseThrow(() -> new UserNotFoundException("Customer not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> save(@Validated Customer customer) {
        var savedCustomer = customerRepository.save(customer);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(savedCustomer.getEmail())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
