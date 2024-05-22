package com.bobrowski.worklog.domain.mappers;

import com.bobrowski.worklog.domain.entity.Client;
import com.bobrowski.worklog.openapi.model.GetClientDto;
import com.bobrowski.worklog.openapi.model.PostClientDto;
import com.bobrowski.worklog.openapi.model.PutClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    Client postDtoToEntity(PostClientDto postClientDto);
    @Mapping(target = "id", ignore = true)
    Client putDtoToEntity(PutClientDto putClientDto);
    GetClientDto entityToGetDto(Client client);
}