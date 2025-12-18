package com.henrico.hexagonal.adapters.in.controller;

import com.henrico.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.henrico.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.henrico.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.henrico.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = CustomerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = CustomerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

}
