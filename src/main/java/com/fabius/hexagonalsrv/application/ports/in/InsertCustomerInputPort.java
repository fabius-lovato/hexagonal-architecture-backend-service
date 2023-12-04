package com.fabius.hexagonalsrv.application.ports.in;

import com.fabius.hexagonalsrv.application.core.domain.Customer;

public interface InsertCustomerInputPort {
	void insert(Customer customer, String zipCode);
}
