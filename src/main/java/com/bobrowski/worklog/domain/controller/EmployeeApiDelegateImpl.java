package com.bobrowski.worklog.domain.controller;

import com.bobrowski.worklog.domain.entity.Employee;
import com.bobrowski.worklog.domain.exceptions.NoEmployeeWithSuchIdException;
import com.bobrowski.worklog.domain.mappers.EmployeeMapper;
import com.bobrowski.worklog.domain.service.api.EmployeeServiceApi;
import com.bobrowski.worklog.openapi.api.EmployeeApiDelegate;
import com.bobrowski.worklog.openapi.model.GetEmployeeDto;
import com.bobrowski.worklog.openapi.model.PostEmployeeDto;
import com.bobrowski.worklog.openapi.model.PutEmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeApiDelegateImpl implements EmployeeApiDelegate {

    private final EmployeeServiceApi employeeService;
    private final EmployeeMapper employeeMapper;

    @Override
    public ResponseEntity<GetEmployeeDto> getEmployee(Long employeeId) {
        Optional<Employee> employeeById = employeeService.findById(employeeId);
        if(employeeById.isPresent()) {
            GetEmployeeDto getEmployeeDto = employeeMapper.entityToGetDto(employeeById.get());
            return new ResponseEntity<>(getEmployeeDto, HttpStatus.OK);
        } else {
            throw new NoEmployeeWithSuchIdException(employeeId);
        }
    }

    @Override
    public ResponseEntity<GetEmployeeDto> postEmployee(PostEmployeeDto postEmployeeDto) {
        Employee savedEmployee = employeeService.save(employeeMapper.postDtoToEntity(postEmployeeDto));
        GetEmployeeDto savedEmployeeDto = employeeMapper.entityToGetDto(savedEmployee);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetEmployeeDto> putEmployee(Long employeeId, PutEmployeeDto putEmployeeDto) {
        Employee employee = employeeMapper.putDtoToEntity(putEmployeeDto);
        employee.setId(employeeId);
        HttpStatus httpStatus = employeeService.existsById(employeeId) ? HttpStatus.ACCEPTED : HttpStatus.CREATED;
        Employee savedEmployee = employeeService.updateOrCreate(employee);
        return new ResponseEntity<>(employeeMapper.entityToGetDto(savedEmployee), httpStatus);
    }
}