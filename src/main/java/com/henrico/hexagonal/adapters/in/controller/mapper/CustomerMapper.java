package com.henrico.hexagonal.adapters.in.controller.mapper;

import com.henrico.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.henrico.hexagonal.adapters.in.controller.response.AddressResponse;
import com.henrico.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.henrico.hexagonal.application.core.domain.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getName(),
                customerRequest.getCpf()
        );
    }

    public static CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse
                .builder()
                .name(customer.getName())
                .address(AddressResponse
                        .builder()
                        .street(customer.getAddress().getStreet())
                        .city(customer.getAddress().getCity())
                        .state(customer.getAddress().getState())
                        .build()
                )
                .cpf(customer.getCpf())
                .isValidCpf(customer.getIsValidCpf())
                .build();
    }
}
