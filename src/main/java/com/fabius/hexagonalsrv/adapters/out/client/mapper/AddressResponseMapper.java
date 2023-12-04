package com.fabius.hexagonalsrv.adapters.out.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fabius.hexagonalsrv.adapters.out.client.response.AddressResponse;
import com.fabius.hexagonalsrv.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

	@Mapping(source = "logradouro", target = "street")
	@Mapping(source = "localidade", target = "city")
	@Mapping(source = "uf", target = "state")
	Address toAddress(AddressResponse addressResponse);
}

