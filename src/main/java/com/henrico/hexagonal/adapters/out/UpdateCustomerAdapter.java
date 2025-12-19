package com.henrico.hexagonal.adapters.out;

import com.henrico.hexagonal.adapters.out.entity.CustomerEntity;
import com.henrico.hexagonal.adapters.out.entity.mapper.CustomerEntityMapper;
import com.henrico.hexagonal.adapters.out.entity.repository.CustomerRepository;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    public UpdateCustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = CustomerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
