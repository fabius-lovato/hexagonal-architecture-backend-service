package com.fabius.hexagonalsrv.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fabius.hexagonalsrv.adapters.in.consumer.message.CustomerMessage;
import com.fabius.hexagonalsrv.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void send(String id, String cpf) {
		CustomerMessage customerMessage = new CustomerMessage(id, null, null, cpf, false);
		
		kafkaTemplate.send("tp-cpf-validation", customerMessage.toString());
	}

}
