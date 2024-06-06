package com.bobrowski.worklog.domain.service.impl;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.domain.repository.CustomerRepository;
import com.bobrowski.worklog.domain.service.api.CustomerServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceApi {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateOrCreate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }
}