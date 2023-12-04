package com.fabius.hexagonalsrv.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fabius.hexagonalsrv.adapters.in.consumer.message.CustomerMessage;
import com.fabius.hexagonalsrv.application.ports.in.UpdateCustomerCpfValidatedByIdInputPort;

@Component
public class ReceiveValidatedCppConsumer {
	@Autowired
	private UpdateCustomerCpfValidatedByIdInputPort updateCustomerCpfValidatedByIdInputPort;

	
	@KafkaListener(topics = "tp-cpf-validated", groupId = "lovato")
	public void receive(CustomerMessage customerMessage) {

		updateCustomerCpfValidatedByIdInputPort.updateCpfValidatedById(customerMessage.getId(), customerMessage.getIsValidCpf());
	}
}
