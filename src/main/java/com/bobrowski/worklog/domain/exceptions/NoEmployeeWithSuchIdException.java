package com.bobrowski.worklog.domain.exceptions;

import java.util.NoSuchElementException;

public class NoEmployeeWithSuchIdException extends NoSuchElementException {

    public NoEmployeeWithSuchIdException(Long id) {
        super("Employee with id: " + id + " not found");
    }
}