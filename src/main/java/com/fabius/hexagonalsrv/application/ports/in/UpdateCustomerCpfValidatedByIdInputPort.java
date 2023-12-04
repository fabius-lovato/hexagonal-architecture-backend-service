package com.fabius.hexagonalsrv.application.ports.in;

public interface UpdateCustomerCpfValidatedByIdInputPort {
	void updateCpfValidatedById(String id, Boolean isCpfValidated);
}
