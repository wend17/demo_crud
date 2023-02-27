package com.wendy.demo.user.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum MessageCode {
    USER_NOTFOUND("error-01","usuario no encontrado",HttpStatus.NOT_FOUND),
    ERROR_02("error-02","mensaje del error 2", HttpStatus.BAD_REQUEST);

    private  String code;
    private  String message;

    private HttpStatus status;

    MessageCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
