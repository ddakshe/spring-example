package com.example.spring.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST,  "유효하지 않는 값"),
    NO_HANDLER_FOUND(HttpStatus.NOT_FOUND, "유효하지 않는 요청")


    ;

    @Getter
    private final String message;

    @Getter
    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
