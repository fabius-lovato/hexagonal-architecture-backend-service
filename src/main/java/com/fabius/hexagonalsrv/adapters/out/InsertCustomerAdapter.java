package com.fabius.hexagonalsrv.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabius.hexagonalsrv.adapters.out.repository.CustomerRepository;
import com.fabius.hexagonalsrv.adapters.out.repository.mapper.CustomerEntityMapper;
import com.fabius.hexagonalsrv.application.core.domain.Customer;
import com.fabius.hexagonalsrv.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {

        var customerEntity = customerEntityMapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }

}
