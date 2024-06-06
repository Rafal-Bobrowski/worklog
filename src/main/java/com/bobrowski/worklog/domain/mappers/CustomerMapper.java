package com.bobrowski.worklog.domain.mappers;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.openapi.model.GetCustomerDto;
import com.bobrowski.worklog.openapi.model.PostCustomerDto;
import com.bobrowski.worklog.openapi.model.PutCustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "records", ignore = true)
    Customer postDtoToEntity(PostCustomerDto postCustomerDto);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "records", ignore = true)
    Customer putDtoToEntity(PutCustomerDto putCustomerDto);
    GetCustomerDto entityToGetDto(Customer customer);
}