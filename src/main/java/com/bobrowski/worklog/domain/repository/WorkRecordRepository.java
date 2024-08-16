package com.bobrowski.worklog.domain.repository;

import com.bobrowski.worklog.domain.entity.WorkRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRecordRepository extends JpaRepository<WorkRecord, Long> {
}