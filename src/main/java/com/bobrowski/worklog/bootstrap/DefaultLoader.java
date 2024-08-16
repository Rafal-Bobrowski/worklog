package com.bobrowski.worklog.bootstrap;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.domain.entity.Employee;
import com.bobrowski.worklog.domain.entity.WorkRecord;
import com.bobrowski.worklog.domain.repository.CustomerRepository;
import com.bobrowski.worklog.domain.repository.EmployeeRepository;
import com.bobrowski.worklog.domain.repository.WorkRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final WorkRecordRepository workRecordRepository;

    @Override
    public void run(String... args) {
        Customer customer = Customer.builder()
                .name("Johny")
                .lastName("Depp")
                .build();
        customerRepository.save(customer);
        Employee employee = Employee.builder()
                .name("Johny_employee")
                .lastName("Depp")
                .build();
        employeeRepository.save(employee);
        WorkRecord workRecord = WorkRecord.builder()
                .date(LocalDate.now())
                .description("Preparing documentation")
                .employee(employee)
                .customer(customer)
                .duration(Duration.ofMinutes(65))
                .build();
        workRecordRepository.save(workRecord);
    }
}