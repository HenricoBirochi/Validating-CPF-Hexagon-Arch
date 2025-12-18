package com.henrico.hexagonal.adapters.out;

import com.henrico.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.henrico.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.henrico.hexagonal.adapters.out.client.response.AddressResponse;
import com.henrico.hexagonal.application.core.domain.Address;
import com.henrico.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return AddressResponseMapper.toAddress(addressResponse);
    }
}
