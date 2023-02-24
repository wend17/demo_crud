package com.wendy.demo.user.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum MessageCode {
    USER_NOTFOUND("error-01","usuario no encontrado",HttpStatus.NOT_FOUND),
    ERROR_02("error-02","mensaje del error 2", HttpStatus.BAD_REQUEST),

    ERROR_03("error-03", "mensaje del error 3", HttpStatus.BAD_REQUEST),

    ERROR_04("error-04","mensaje del error 4", HttpStatus.INTERNAL_SERVER_ERROR),

    ERROR_10("error-10","mensaje del error 10",HttpStatus.BAD_REQUEST);



    private  String code;
    private  String message;

    private HttpStatus status;

    MessageCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
