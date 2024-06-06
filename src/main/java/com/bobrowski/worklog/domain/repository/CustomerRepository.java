package com.bobrowski.worklog.domain.repository;

import com.bobrowski.worklog.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}