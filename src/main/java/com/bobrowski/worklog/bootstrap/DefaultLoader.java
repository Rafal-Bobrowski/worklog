package com.bobrowski.worklog.bootstrap;

import com.bobrowski.worklog.domain.entity.Customer;
import com.bobrowski.worklog.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        Customer customer = Customer.builder()
                .name("Johny")
                .lastName("Depp")
                .build();
        customerRepository.save(customer);
    }
}