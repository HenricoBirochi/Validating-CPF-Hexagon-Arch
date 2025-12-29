package com.henrico.hexagonal.adapters.in.consumer;

import com.henrico.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.henrico.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.henrico.hexagonal.application.core.domain.Customer;
import com.henrico.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private UpdateCustomerInputPort updateCustomerInputPort;

    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort) {
        this.updateCustomerInputPort = updateCustomerInputPort;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "henrico")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = CustomerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}
