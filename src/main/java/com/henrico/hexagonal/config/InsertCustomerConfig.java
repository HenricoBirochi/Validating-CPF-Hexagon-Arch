package com.henrico.hexagonal.config;

import com.henrico.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.henrico.hexagonal.adapters.out.InsertCustomerAdapter;
import com.henrico.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.henrico.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
