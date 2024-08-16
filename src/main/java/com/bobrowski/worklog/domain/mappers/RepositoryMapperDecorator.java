package com.bobrowski.worklog.domain.mappers;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.domain.entity.Employee;
import com.bobrowski.worklog.domain.exceptions.NoCustomerWithSuchIdException;
import com.bobrowski.worklog.domain.service.api.CustomerServiceApi;
import com.bobrowski.worklog.domain.service.api.EmployeeServiceApi;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class RepositoryMapperDecorator {

    @Autowired
    private CustomerServiceApi customerService;
    @Autowired
    private EmployeeServiceApi employeeService;

    public Customer mapToCustomer(Long id){
        return customerService.findById(id).orElseThrow(() -> new NoCustomerWithSuchIdException(id));
    }
    public Employee mapToEmployee(long id){
        return employeeService.findById(id).orElseThrow(() -> new NoCustomerWithSuchIdException(id));
    }
}
