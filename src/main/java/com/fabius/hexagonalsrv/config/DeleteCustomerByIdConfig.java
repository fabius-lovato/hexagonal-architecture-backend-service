package com.fabius.hexagonalsrv.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabius.hexagonalsrv.adapters.out.DeleteCustomerByIdAdapter;
import com.fabius.hexagonalsrv.application.core.usecases.DeleteCustomerByIdUseCase;
import com.fabius.hexagonalsrv.application.core.usecases.FindCustomerByIdUseCase;


@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}
