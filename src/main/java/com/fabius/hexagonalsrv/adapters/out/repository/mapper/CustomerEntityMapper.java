package com.fabius.hexagonalsrv.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.fabius.hexagonalsrv.adapters.out.repository.entity.CustomerEntity;
import com.fabius.hexagonalsrv.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
