package com.bobrowski.worklog.domain.exceptions;

import java.util.NoSuchElementException;

public class NoWorkRecordWithSuchIdException extends NoSuchElementException {

    public NoWorkRecordWithSuchIdException(Long id) {
        super("Record with id: " + id + " not found");
    }
}