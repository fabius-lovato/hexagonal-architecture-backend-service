package com.fabius.hexagonalsrv.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabius.hexagonalsrv.adapters.in.controller.mapper.CustomerMapper;
import com.fabius.hexagonalsrv.adapters.in.controller.request.CustomerRequest;
import com.fabius.hexagonalsrv.adapters.in.controller.request.CustomerUpdateRequest;
import com.fabius.hexagonalsrv.adapters.in.controller.response.CustomerResponse;
import com.fabius.hexagonalsrv.application.ports.in.DeleteCustomerByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.in.FindCustomerByIdInputPort;
import com.fabius.hexagonalsrv.application.ports.in.InsertCustomerInputPort;
import com.fabius.hexagonalsrv.application.ports.in.UpdateCustomerAddressByZipCodeInputPort;



@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerAddressByZipCodeInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody CustomerRequest customerRequest) {

        var customer = customerMapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {

		try {
            var customer = findCustomerByIdInputPort.find(id);

            var customerResponse = customerMapper.toCustomerResponse(customer);

            return ResponseEntity.ok().body(customerResponse);
		} catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }

	@PatchMapping("/{id}")
	public ResponseEntity<Void> update(
			@PathVariable String id,
			@Validated @RequestBody CustomerUpdateRequest customerUpdateRequest)
	{
		try {
            updateCustomerInputPort.updateZipCode(id, customerUpdateRequest.getZipCode());

            return ResponseEntity.noContent().build();
		} catch (Exception e) {

		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
            deleteCustomerByIdInputPort.delete(id);

            return ResponseEntity.noContent().build();
		} catch (Exception e) {

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
