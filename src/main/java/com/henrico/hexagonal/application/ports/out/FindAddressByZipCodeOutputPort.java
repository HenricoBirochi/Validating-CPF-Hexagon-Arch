package com.henrico.hexagonal.application.ports.out;

import com.henrico.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
