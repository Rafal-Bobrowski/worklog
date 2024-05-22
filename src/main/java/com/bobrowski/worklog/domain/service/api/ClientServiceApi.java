package com.bobrowski.worklog.domain.service.api;

import com.bobrowski.worklog.domain.entity.Client;

import java.util.Optional;

public interface ClientServiceApi {

    Optional<Client> findById(Long id);

    Client save(Client client);

    Client updateOrCreate(Client client);

    boolean existsById(Long id);
}