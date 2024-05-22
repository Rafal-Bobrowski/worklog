package com.bobrowski.worklog.domain.controller;

import com.bobrowski.worklog.domain.entity.Client;
import com.bobrowski.worklog.domain.exceptions.NoClientWithSuchIdException;
import com.bobrowski.worklog.domain.mappers.ClientMapper;
import com.bobrowski.worklog.domain.service.api.ClientServiceApi;
import com.bobrowski.worklog.openapi.api.ClientApiDelegate;
import com.bobrowski.worklog.openapi.model.GetClientDto;
import com.bobrowski.worklog.openapi.model.PostClientDto;
import com.bobrowski.worklog.openapi.model.PutClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientApiDelegateImpl implements ClientApiDelegate {

    private final ClientServiceApi clientService;
    private final ClientMapper clientMapper;

    @Override
    public ResponseEntity<GetClientDto> getClient(Integer clientId) {
        Optional<Client> clientById = clientService.findById(Long.valueOf(clientId));
        if(clientById.isPresent()) {
            GetClientDto getClientDto = clientMapper.entityToGetDto(clientById.get());
            return new ResponseEntity<>(getClientDto, HttpStatus.OK);
        } else {
            throw new NoClientWithSuchIdException(Long.valueOf(clientId));
        }
    }

    @Override
    public ResponseEntity<GetClientDto> postClient(PostClientDto postClientDto) {
        Client savedClient = clientService.save(clientMapper.postDtoToEntity(postClientDto));
        GetClientDto savedClientDto = clientMapper.entityToGetDto(savedClient);
        return new ResponseEntity<>(savedClientDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetClientDto> putClient(Integer clientId, PutClientDto putClientDto) {
        Client client = clientMapper.putDtoToEntity(putClientDto);
        client.setId(Long.valueOf(clientId));
        HttpStatus httpStatus = clientService.existsById(Long.valueOf(clientId)) ? HttpStatus.ACCEPTED : HttpStatus.CREATED;
        Client savedClient = clientService.updateOrCreate(client);
        return new ResponseEntity<>(clientMapper.entityToGetDto(savedClient), httpStatus);
    }
}