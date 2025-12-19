package com.henrico.hexagonal.adapters.in.controller;

import com.henrico.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.henrico.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.henrico.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.henrico.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.henrico.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.henrico.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            UpdateCustomerInputPort updateCustomerInputPort,
            DeleteCustomerByIdInputPort deleteCustomerByIdInputPort
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable final String id,
            @Valid @RequestBody CustomerRequest customerRequest
    ) {
        Customer customer = CustomerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
