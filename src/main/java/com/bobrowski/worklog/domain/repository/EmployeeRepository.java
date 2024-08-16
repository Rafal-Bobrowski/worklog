package com.bobrowski.worklog.domain.repository;

import com.bobrowski.worklog.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}