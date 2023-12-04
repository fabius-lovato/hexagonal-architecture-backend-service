package com.fabius.hexagonalsrv.application.ports.out;

import com.fabius.hexagonalsrv.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

	void insert(Customer customer);
}
