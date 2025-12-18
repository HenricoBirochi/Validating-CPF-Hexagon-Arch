package com.henrico.hexagonal.adapters.in.controller;

import com.henrico.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.henrico.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private InsertCustomerInputPort insertCustomerInputPort;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = CustomerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

}
