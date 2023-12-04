package com.fabius.hexagonalsrv.application.ports.out;

public interface SendCpfForValidationOutputPort {

	void send(String id, String cpf);
}
