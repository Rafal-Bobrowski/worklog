package com.bobrowski.worklog.domain.exceptions;

import com.bobrowski.worklog.openapi.model.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoClientWithSuchIdException.class})
    protected ResponseEntity<Object> handleNoClientWithSuchIdException(Exception ex, WebRequest request){
        ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                .responseCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .code(4041)
                .build();
        return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}