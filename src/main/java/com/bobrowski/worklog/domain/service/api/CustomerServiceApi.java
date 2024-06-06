package com.bobrowski.worklog.domain.service.api;

import com.bobrowski.worklog.domain.entity.Customer;

import java.util.Optional;

public interface CustomerServiceApi {

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    Customer updateOrCreate(Customer customer);

    boolean existsById(Long id);
}