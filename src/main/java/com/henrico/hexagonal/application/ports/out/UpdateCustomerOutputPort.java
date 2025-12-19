package com.henrico.hexagonal.application.ports.out;

import com.henrico.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
