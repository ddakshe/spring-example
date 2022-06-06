package com.example.spring.config.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST,  "유효하지 않는 요청 데이터"),
    NO_HANDLER_FOUND(HttpStatus.NOT_FOUND, "유효하지 않는 요청 URL"),
    NOT_EXIST_TEAM(HttpStatus.NOT_FOUND, "존재하지 않는 팀")
    ;

    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
