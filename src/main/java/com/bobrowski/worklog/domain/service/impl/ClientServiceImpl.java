package com.bobrowski.worklog.domain.service.impl;

import com.bobrowski.worklog.domain.entity.Client;
import com.bobrowski.worklog.domain.repository.ClientRepository;
import com.bobrowski.worklog.domain.service.api.ClientServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientServiceApi {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateOrCreate(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }
}