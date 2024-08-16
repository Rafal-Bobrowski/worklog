package com.bobrowski.worklog.domain.mappers;

import com.bobrowski.worklog.domain.entity.Employee;
import com.bobrowski.worklog.openapi.model.GetEmployeeDto;
import com.bobrowski.worklog.openapi.model.PostEmployeeDto;
import com.bobrowski.worklog.openapi.model.PutEmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workRecords", ignore = true)
    Employee postDtoToEntity(PostEmployeeDto postEmployeeDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workRecords", ignore = true)
    Employee putDtoToEntity(PutEmployeeDto putEmployeeDto);

    GetEmployeeDto entityToGetDto(Employee employee);
}