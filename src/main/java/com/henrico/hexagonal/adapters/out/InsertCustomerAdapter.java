package com.henrico.hexagonal.adapters.out;

import com.henrico.hexagonal.adapters.out.entity.CustomerEntity;
import com.henrico.hexagonal.adapters.out.entity.repository.CustomerRepository;
import com.henrico.hexagonal.adapters.out.entity.mapper.CustomerEntityMapper;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    public InsertCustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = CustomerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
