package com.example.spring.config.exception.response;
import com.example.spring.config.exception.ErrorCode;
import lombok.Getter;

@Getter
public abstract class ErrorResponse {

    private final ErrorCode errorCode;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
