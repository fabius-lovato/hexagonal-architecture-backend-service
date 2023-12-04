package com.fabius.hexagonalsrv.application.core.usecases;

import com.fabius.hexagonalsrv.application.core.domain.Customer;
import com.fabius.hexagonalsrv.application.ports.in.FindCustomerByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.in.UpdateCustomerCpfValidatedByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerCpfValidatedByIdUseCase implements UpdateCustomerCpfValidatedByIdInputPort {

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	
	private final UpdateCustomerOutputPort updateCustomerOutputPort;
	
	public UpdateCustomerCpfValidatedByIdUseCase (
			FindCustomerByIdInputPort findCustomerByIdInputPort,
			UpdateCustomerOutputPort updateCustomerOutputPort
	) {
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.updateCustomerOutputPort = updateCustomerOutputPort;
	}
	
	@Override
	public void updateCpfValidatedById(String id, Boolean isCpfValidated) {
		Customer customer = findCustomerByIdInputPort.find(id);
		
		customer.setIsValidCpf(isCpfValidated);
		
		updateCustomerOutputPort.update(customer);
	}

}
