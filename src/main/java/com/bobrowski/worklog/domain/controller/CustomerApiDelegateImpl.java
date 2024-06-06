package com.bobrowski.worklog.domain.controller;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.domain.exceptions.NoCustomerWithSuchIdException;
import com.bobrowski.worklog.domain.mappers.CustomerMapper;
import com.bobrowski.worklog.domain.service.api.CustomerServiceApi;
import com.bobrowski.worklog.openapi.api.CustomerApiDelegate;
import com.bobrowski.worklog.openapi.model.GetCustomerDto;
import com.bobrowski.worklog.openapi.model.PostCustomerDto;
import com.bobrowski.worklog.openapi.model.PutCustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerApiDelegateImpl implements CustomerApiDelegate {

    private final CustomerServiceApi customerService;
    private final CustomerMapper customerMapper;

    @Override
    public ResponseEntity<GetCustomerDto> getCustomer(Long customerId) {
        Optional<Customer> customerById = customerService.findById(customerId);
        if(customerById.isPresent()) {
            GetCustomerDto getCustomerDto = customerMapper.entityToGetDto(customerById.get());
            return new ResponseEntity<>(getCustomerDto, HttpStatus.OK);
        } else {
            throw new NoCustomerWithSuchIdException(customerId);
        }
    }

    @Override
    public ResponseEntity<GetCustomerDto> postCustomer(PostCustomerDto postCustomerDto) {
        Customer savedCustomer = customerService.save(customerMapper.postDtoToEntity(postCustomerDto));
        GetCustomerDto savedCustomerDto = customerMapper.entityToGetDto(savedCustomer);
        return new ResponseEntity<>(savedCustomerDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetCustomerDto> putCustomer(Long customerId, PutCustomerDto putCustomerDto) {
        Customer customer = customerMapper.putDtoToEntity(putCustomerDto);
        customer.setId(customerId);
        HttpStatus httpStatus = customerService.existsById(customerId) ? HttpStatus.ACCEPTED : HttpStatus.CREATED;
        Customer savedCustomer = customerService.updateOrCreate(customer);
        return new ResponseEntity<>(customerMapper.entityToGetDto(savedCustomer), httpStatus);
    }
}