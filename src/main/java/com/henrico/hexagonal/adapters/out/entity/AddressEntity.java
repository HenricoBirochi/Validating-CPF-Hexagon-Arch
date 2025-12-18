package com.henrico.hexagonal.adapters.out.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressEntity {
    private String street;
    private String city;
    private String state;
}
