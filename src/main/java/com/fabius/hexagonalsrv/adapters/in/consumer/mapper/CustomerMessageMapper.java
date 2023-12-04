package com.fabius.hexagonalsrv.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fabius.hexagonalsrv.adapters.in.consumer.message.CustomerMessage;
import com.fabius.hexagonalsrv.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

	@Mapping(target = "address", ignore = true)
	Customer toCustomer(CustomerMessage customerMessage);

}
