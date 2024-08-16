package com.bobrowski.worklog.domain.service.impl;

import com.bobrowski.worklog.domain.entity.Employee;
import com.bobrowski.worklog.domain.repository.EmployeeRepository;
import com.bobrowski.worklog.domain.service.api.EmployeeServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceApi {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateOrCreate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }
}