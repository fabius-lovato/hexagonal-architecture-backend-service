package com.fabius.hexagonalsrv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabius.hexagonalsrv.adapters.out.FindAddressByZipCodeAdapter;
import com.fabius.hexagonalsrv.adapters.out.UpdateCustomerAdapter;
import com.fabius.hexagonalsrv.application.core.usecases.FindCustomerByIdUseCase;
import com.fabius.hexagonalsrv.application.core.usecases.UpdateCustomerAddressByZipCodeUseCase;


@Configuration
public class UpdateCustomerAddressByZipCodeConfig {

    @Bean
    public UpdateCustomerAddressByZipCodeUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerAddressByZipCodeUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
