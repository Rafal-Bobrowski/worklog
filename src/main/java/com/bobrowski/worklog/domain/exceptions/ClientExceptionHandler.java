package com.bobrowski.worklog.domain.exceptions;

import com.bobrowski.worklog.openapi.model.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        String message;
        if (objectError instanceof FieldError fieldError){
            message = "Property with name: " + fieldError.getField() + " in object: " + fieldError.getObjectName() + " cannot be: " + fieldError.getRejectedValue();
            ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                    .responseCode(HttpStatus.BAD_REQUEST.value())
                    .message(message)
                    .code(4041)
                    .build();
            return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}