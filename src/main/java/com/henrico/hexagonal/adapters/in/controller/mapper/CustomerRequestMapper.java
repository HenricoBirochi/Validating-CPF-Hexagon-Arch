package com.henrico.hexagonal.adapters.in.controller.mapper;

import com.henrico.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.henrico.hexagonal.application.core.domain.Customer;

public class CustomerRequestMapper {
    public static Customer toCustomer(CustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getName(),
                customerRequest.getCpf()
        );
    }
}
