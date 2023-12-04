package com.fabius.hexagonalsrv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabius.hexagonalsrv.adapters.out.FindAddressByZipCodeAdapter;
import com.fabius.hexagonalsrv.adapters.out.InsertCustomerAdapter;
import com.fabius.hexagonalsrv.adapters.out.SendCpfForValidationAdapter;
import com.fabius.hexagonalsrv.application.core.usecases.InsertCustomerUseCase;


@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationOutputPortAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationOutputPortAdapter);
    }

}
