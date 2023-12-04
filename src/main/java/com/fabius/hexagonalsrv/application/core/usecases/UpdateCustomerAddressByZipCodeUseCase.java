package com.fabius.hexagonalsrv.application.core.usecases;

import com.fabius.hexagonalsrv.application.ports.in.FindCustomerByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.in.UpdateCustomerAddressByZipCodeInputPort;
import com.fabius.hexagonalsrv.application.ports.out.FindAddressByZipCodeOutputPort;
import com.fabius.hexagonalsrv.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerAddressByZipCodeUseCase implements UpdateCustomerAddressByZipCodeInputPort {

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;

	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

	private final UpdateCustomerOutputPort updateCustomerOutputPort;

	public UpdateCustomerAddressByZipCodeUseCase(
			FindCustomerByIdInputPort findCustomerByIdInputPort,
			FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
			UpdateCustomerOutputPort updateCustomerOutputPort
	) {
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.updateCustomerOutputPort = updateCustomerOutputPort;
	}

	@Override
	public void updateZipCode(String id, String zipCode) {

		var customer = findCustomerByIdInputPort.find(id);

		var address = findAddressByZipCodeOutputPort.find(zipCode);

		customer.setAddress(address);

		updateCustomerOutputPort.update(customer);
	}
}
