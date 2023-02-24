package com.wendy.demo.user.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {DemoException.class })
    protected ResponseEntity<Object> handleConflict(
            DemoException ex, WebRequest request) {
       ResponseMessage response = new ResponseMessage();
       response.setCode(ex.getMessageCode().getCode());
       response.setMessage(ex.getMessageCode().getMessage());
        return handleExceptionInternal(ex,response,
                new HttpHeaders(), ex.getMessageCode().getStatus(), request);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class })
    protected ResponseEntity<Object> handleException(
            DemoException ex, WebRequest request) {
        return handleExceptionInternal(ex,"error interno",
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
}
