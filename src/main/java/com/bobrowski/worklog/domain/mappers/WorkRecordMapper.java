package com.bobrowski.worklog.domain.mappers;

import com.bobrowski.worklog.domain.entity.WorkRecord;
import com.bobrowski.worklog.openapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Duration;

@Mapper(uses = {RepositoryMapperDecorator.class})
public interface WorkRecordMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", source = "employeeId")
    @Mapping(target = "customer", source = "customerId")
    WorkRecord postDtoToEntity(PostWorkRecordDto postRecordDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", source = "employeeId")
    @Mapping(target = "customer", source = "customerId")
    WorkRecord putDtoToEntity(PutWorkRecordDto putRecordDto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "employeeId", source = "employee.id")
    GetWorkRecordDto entityToGetDto(WorkRecord workRecord);

    default Duration intToDuration(Integer duration){
        return Duration.ofMinutes(duration);
    }

    default Integer durationToInt(Duration duration){
        return Math.toIntExact(duration.toMinutes());
    }
}