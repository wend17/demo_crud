package com.wendy.demo.user.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    private String code;
    private String message;
}
