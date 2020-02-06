package com.ere.service.account.common;

import com.ere.service.account.domain.AddressType;
import com.ere.service.account.domain.CreditCardType;
import com.ere.service.account.domain.entity.Account;
import com.ere.service.account.domain.entity.Address;
import com.ere.service.account.domain.entity.CreditCard;
import com.ere.service.account.domain.entity.Customer;
import com.ere.service.account.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("dev")
public class AccountApplicationIntTest {

    @Autowired
    CustomerRepository customerRepository;

    String accountNumber = "12345";

    @Test
    void shouldCreateCustomer() {
        var account = new Account(accountNumber);
        var customer = new Customer("Ivan", "Ivanov", "s@mail.ru", account);
        var creditCard = new CreditCard("1232131231", CreditCardType.VISA);
        customer.getAccount().getCreditCards().add(creditCard);

        var street1 = "New 1 flat 12";
        var address = new Address(street1, null, "DC", "Washington",
                "USA", 20500, AddressType.PHYSICAL);
        customer.getAccount().getAddresses().add(address);

        customer = customerRepository.save(customer);
        var savedCustomer = customerRepository.findById(customer.getId());
        assertTrue(savedCustomer.isPresent());
        assertNotNull(savedCustomer.get().getAccount());
        assertNotNull(savedCustomer.get().getCreatedAt());
        assertNotNull(savedCustomer.get().getLastModify());

        assertTrue(savedCustomer.get().getAccount().getAddresses().stream()
                .anyMatch(add -> add.getStreet1().equalsIgnoreCase(street1)));

        customerRepository.findByEmailContaining(customer.getEmail())
                .orElseThrow(() -> new RuntimeException("data null"));
    }

}
