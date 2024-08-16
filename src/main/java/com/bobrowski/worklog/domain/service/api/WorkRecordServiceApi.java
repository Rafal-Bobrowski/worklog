package com.bobrowski.worklog.domain.service.api;

import com.bobrowski.worklog.domain.entity.WorkRecord;

import java.util.Optional;

public interface WorkRecordServiceApi {

    Optional<WorkRecord> findById(Long id);

    WorkRecord save(WorkRecord workRecord);

    WorkRecord updateOrCreate(WorkRecord workRecord);

    boolean existsById(Long id);
}