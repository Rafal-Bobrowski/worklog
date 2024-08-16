package com.bobrowski.worklog.domain.service.api;

import com.bobrowski.worklog.domain.entity.Employee;

import java.util.Optional;

public interface EmployeeServiceApi {

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    Employee updateOrCreate(Employee employee);

    boolean existsById(Long id);
}