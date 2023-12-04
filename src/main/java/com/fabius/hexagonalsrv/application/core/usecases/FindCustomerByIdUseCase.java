package com.fabius.hexagonalsrv.application.core.usecases;

import com.fabius.hexagonalsrv.application.core.domain.Customer;
import com.fabius.hexagonalsrv.application.ports.in.FindCustomerByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

	private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

	public FindCustomerByIdUseCase(
			FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
		super();
		this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
	}

	@Override
	public Customer find(String id) throws RuntimeException {
		var customer = findCustomerByIdOutputPort.find(id);

		if (!customer.isPresent())
			throw new RuntimeException("Customer not found!");

		return customer.get();
	}

}
