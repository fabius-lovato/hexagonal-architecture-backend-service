package com.fabius.hexagonalsrv.application.core.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fabius.hexagonalsrv.application.core.domain.Customer;
import com.fabius.hexagonalsrv.application.ports.in.InsertCustomerInputPort;
import com.fabius.hexagonalsrv.application.ports.out.FindAddressByZipCodeOutputPort;
import com.fabius.hexagonalsrv.application.ports.out.InsertCustomerOutputPort;
import com.fabius.hexagonalsrv.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
	private final Logger logger = LoggerFactory.getLogger(InsertCustomerUseCase.class);

	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

	private final InsertCustomerOutputPort insertCustomerOutputPort;
	
	private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

	public InsertCustomerUseCase(
			FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
			InsertCustomerOutputPort insertCustomerOutputPort,
			SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
		super();
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
		this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
	}

	@Override
	public void insert(Customer customer, String zipCode) {
		// Busca o endereço correspondente ao CEP.
		var address = findAddressByZipCodeOutputPort.find(zipCode);

		customer.setAddress(address);

		try {
			// Persiste na base de dados o Cadastro do Cliente.
			insertCustomerOutputPort.insert(customer);
			
			// Envia no CPF para validação.
			sendCpfForValidationOutputPort.send(customer.getId(), customer.getCpf());
		} catch (Exception e) {
			logger.error("Failure inserting customer in database.");
		}
	}
}
