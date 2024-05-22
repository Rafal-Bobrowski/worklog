package com.bobrowski.worklog.domain.repository;

import com.bobrowski.worklog.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}