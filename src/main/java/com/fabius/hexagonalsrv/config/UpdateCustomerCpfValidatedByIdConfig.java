package com.fabius.hexagonalsrv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabius.hexagonalsrv.adapters.out.UpdateCustomerAdapter;
import com.fabius.hexagonalsrv.application.core.usecases.FindCustomerByIdUseCase;
import com.fabius.hexagonalsrv.application.core.usecases.UpdateCustomerCpfValidatedByIdUseCase;

@Configuration
public class UpdateCustomerCpfValidatedByIdConfig {

    @Bean
    public UpdateCustomerCpfValidatedByIdUseCase updateCustomerCpfValidatedByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerCpfValidatedByIdUseCase(findCustomerByIdUseCase, updateCustomerAdapter);
    }

}