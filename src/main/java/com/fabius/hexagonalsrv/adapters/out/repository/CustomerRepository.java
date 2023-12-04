package com.fabius.hexagonalsrv.adapters.out.repository;

import com.fabius.hexagonalsrv.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>  {

}
