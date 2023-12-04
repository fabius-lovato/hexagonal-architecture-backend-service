package com.fabius.hexagonalsrv.application.ports.in;

import com.fabius.hexagonalsrv.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

	Customer find(String id) throws RuntimeException;
}
