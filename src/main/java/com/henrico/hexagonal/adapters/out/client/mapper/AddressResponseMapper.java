package com.henrico.hexagonal.adapters.out.client.mapper;

import com.henrico.hexagonal.adapters.out.client.response.AddressResponse;
import com.henrico.hexagonal.application.core.domain.Address;

public class AddressResponseMapper {
    public static Address toAddress(AddressResponse addressResponse) {
        return new Address(
                addressResponse.getStreet(),
                addressResponse.getCity(),
                addressResponse.getState()
        );
    }
}
