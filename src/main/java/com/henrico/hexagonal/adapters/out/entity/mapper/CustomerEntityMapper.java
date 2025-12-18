package com.henrico.hexagonal.adapters.out.entity.mapper;

import com.henrico.hexagonal.adapters.out.entity.CustomerEntity;
import com.henrico.hexagonal.application.core.domain.Customer;

public class CustomerEntityMapper {
    public static CustomerEntity toCustomerEntity(Customer customer) {
        return CustomerEntity
                .builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(AddressEntityMapper.toAddressEntity(customer.getAddress()))
                .cpf(customer.getCpf())
                .isValidCpf(customer.getIsValidCpf())
                .build();
    }
    public static Customer toCustomer(CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getName(),
                AddressEntityMapper.toAddress(customerEntity.getAddress()),
                customerEntity.getCpf(),
                customerEntity.getIsValidCpf()
        );
    }
}
