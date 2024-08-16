package com.bobrowski.worklog.domain.controller;

import com.bobrowski.worklog.domain.entity.WorkRecord;
import com.bobrowski.worklog.domain.exceptions.NoWorkRecordWithSuchIdException;
import com.bobrowski.worklog.domain.mappers.WorkRecordMapper;
import com.bobrowski.worklog.domain.service.api.WorkRecordServiceApi;
import com.bobrowski.worklog.openapi.api.WorkRecordApiDelegate;
import com.bobrowski.worklog.openapi.model.GetWorkRecordDto;
import com.bobrowski.worklog.openapi.model.PostWorkRecordDto;
import com.bobrowski.worklog.openapi.model.PutWorkRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkRecordApiDelegateImpl implements WorkRecordApiDelegate {

    private final WorkRecordServiceApi workRecordService;
    private final WorkRecordMapper workRecordMapper;

    @Override
    public ResponseEntity<GetWorkRecordDto> getWorkRecord(Long workRecordId) {
        Optional<WorkRecord> workRecordById = workRecordService.findById(workRecordId);
        if(workRecordById.isPresent()) {
            GetWorkRecordDto getWorkRecordDto = workRecordMapper.entityToGetDto(workRecordById.get());
            return new ResponseEntity<>(getWorkRecordDto, HttpStatus.OK);
        } else {
            throw new NoWorkRecordWithSuchIdException(workRecordId);
        }
    }

    @Override
    public ResponseEntity<GetWorkRecordDto> postWorkRecord(PostWorkRecordDto postWorkRecordDto) {
        WorkRecord savedWorkRecord = workRecordService.save(workRecordMapper.postDtoToEntity(postWorkRecordDto));
        GetWorkRecordDto savedWorkRecordDto = workRecordMapper.entityToGetDto(savedWorkRecord);
        return new ResponseEntity<>(savedWorkRecordDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetWorkRecordDto> putWorkRecord(Long workRecordId, PutWorkRecordDto putWorkRecordDto) {
        WorkRecord workRecord = workRecordMapper.putDtoToEntity(putWorkRecordDto);
        workRecord.setId(workRecordId);
        HttpStatus httpStatus = workRecordService.existsById(workRecordId) ? HttpStatus.ACCEPTED : HttpStatus.CREATED;
        WorkRecord savedWorkRecord = workRecordService.updateOrCreate(workRecord);
        return new ResponseEntity<>(workRecordMapper.entityToGetDto(savedWorkRecord), httpStatus);
    }
}