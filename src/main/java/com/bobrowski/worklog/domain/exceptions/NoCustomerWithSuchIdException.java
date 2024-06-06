package com.bobrowski.worklog.domain.exceptions;

import java.util.NoSuchElementException;

public class NoCustomerWithSuchIdException extends NoSuchElementException {

    public NoCustomerWithSuchIdException(Long id) {
        super("Customer with id: " + id + " not found");
    }
}