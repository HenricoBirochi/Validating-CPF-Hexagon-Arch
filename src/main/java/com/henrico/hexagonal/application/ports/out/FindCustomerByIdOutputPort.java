package com.henrico.hexagonal.application.ports.out;

import com.henrico.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
