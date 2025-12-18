package com.henrico.hexagonal.adapters.out.entity.repository;

import com.henrico.hexagonal.adapters.out.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
