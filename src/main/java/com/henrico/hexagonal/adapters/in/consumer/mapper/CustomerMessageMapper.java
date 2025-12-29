package com.henrico.hexagonal.adapters.in.consumer.mapper;

import com.henrico.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.henrico.hexagonal.application.core.domain.Customer;

public class CustomerMessageMapper {

    public static Customer toCustomer(CustomerMessage customerMessage) {
        return new Customer(
                customerMessage.getId(),
                customerMessage.getName(),
                customerMessage.getCpf(),
                customerMessage.getIsValidCpf()
        );
    }

}
