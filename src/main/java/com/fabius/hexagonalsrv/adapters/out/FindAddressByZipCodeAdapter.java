package com.fabius.hexagonalsrv.adapters.out;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabius.hexagonalsrv.adapters.out.client.FindAddressByZipCodeClient;
import com.fabius.hexagonalsrv.adapters.out.client.mapper.AddressResponseMapper;
import com.fabius.hexagonalsrv.application.core.domain.Address;
import com.fabius.hexagonalsrv.application.ports.out.FindAddressByZipCodeOutputPort;

import io.micrometer.common.util.StringUtils;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {
	Logger logger = LoggerFactory.getLogger(FindAddressByZipCodeAdapter.class);

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
	public Address find(String zipCode) {

		try {
			var addressResponse = findAddressByZipCodeClient.find(zipCode);
			
			if (!Objects.isNull(addressResponse) && !StringUtils.isBlank(addressResponse.getUf()))
				return addressResponseMapper.toAddress(addressResponse);
			
			logger.error(String.format("It was not possible to get the address from %s zipcode!", zipCode));
		} catch (Exception e) {
			logger.error(String.format("Failure getting address from %s zipcode. Unknown error!", zipCode));
		}

		return null;
	}

}
