package com.henrico.hexagonal.adapters.out;

import com.henrico.hexagonal.adapters.out.entity.mapper.CustomerEntityMapper;
import com.henrico.hexagonal.adapters.out.entity.repository.CustomerRepository;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> CustomerEntityMapper.toCustomer(entity));
    }
}
