package com.fabius.hexagonalsrv.application.ports.out;

import com.fabius.hexagonalsrv.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

	Address find(String zipCode);
	
}
