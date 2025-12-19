package com.henrico.hexagonal.config;

import com.henrico.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.henrico.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.henrico.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.henrico.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
