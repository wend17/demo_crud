package com.wendy.demo.user.exceptions;

import lombok.Data;

@Data
public class DemoException extends RuntimeException{
    private MessageCode messageCode;

    public DemoException(MessageCode messageCode){
        super(messageCode.getMessage());
        this.messageCode=messageCode;

    }
}
