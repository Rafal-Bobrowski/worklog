package com.bobrowski.worklog.domain.exceptions;

import java.util.NoSuchElementException;

public class NoClientWithSuchIdException extends NoSuchElementException {

    public NoClientWithSuchIdException(Long id) {
        super("Client with id: " + id + " not found");
    }
}