package com.fabius.hexagonalsrv.application.ports.out;

import java.util.Optional;

import com.fabius.hexagonalsrv.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

	Optional<Customer> find(String id);

}
