package com.bobrowski.worklog.domain.service.impl;

import com.bobrowski.worklog.domain.entity.WorkRecord;
import com.bobrowski.worklog.domain.repository.WorkRecordRepository;
import com.bobrowski.worklog.domain.service.api.WorkRecordServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkRecordServiceImpl implements WorkRecordServiceApi {

    private final WorkRecordRepository workRecordRepository;

    @Override
    public Optional<WorkRecord> findById(Long id) {
        return workRecordRepository.findById(id);
    }

    @Override
    public WorkRecord save(WorkRecord workRecord) {
        return workRecordRepository.save(workRecord);
    }

    @Override
    public WorkRecord updateOrCreate(WorkRecord workRecord) {
        return workRecordRepository.save(workRecord);
    }

    @Override
    public boolean existsById(Long id) {
        return workRecordRepository.existsById(id);
    }
}