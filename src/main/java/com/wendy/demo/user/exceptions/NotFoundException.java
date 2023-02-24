package com.wendy.demo.user.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundException extends RuntimeException{
    private MessageCode messageCode;

    public NotFoundException(MessageCode messageCode){
        super(messageCode.getMessage());
        this.messageCode=messageCode;

    }
}
