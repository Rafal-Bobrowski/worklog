package com.bobrowski.worklog.bootstrap;

import com.bobrowski.worklog.domain.entity.Client;
import com.bobrowski.worklog.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;

    @Override
    public void run(String... args) {
        Client client = Client.builder()
                .name("Johny")
                .lastName("Depp")
                .build();
        clientRepository.save(client);
    }
}