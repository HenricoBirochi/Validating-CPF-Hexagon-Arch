package com.henrico.hexagonal.adapters.in.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {
    private String street;
    private String city;
    private String state;
}
