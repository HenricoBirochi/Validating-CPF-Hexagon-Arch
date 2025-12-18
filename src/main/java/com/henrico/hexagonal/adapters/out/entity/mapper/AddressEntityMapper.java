package com.henrico.hexagonal.adapters.out.entity.mapper;

import com.henrico.hexagonal.adapters.out.entity.AddressEntity;
import com.henrico.hexagonal.application.core.domain.Address;

public class AddressEntityMapper {
    public static AddressEntity toAddressEntity(Address address) {
        return AddressEntity
                .builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }
    public static Address toAddress(AddressEntity addressEntity) {
        return new Address(
                addressEntity.getStreet(),
                addressEntity.getCity(),
                addressEntity.getStreet()
        );
    }
}
