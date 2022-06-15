package com.example.spring.exception.response;
import com.example.spring.exception.ErrorCode;
import lombok.Getter;

@Getter
public abstract class ErrorResponse {

    private final ErrorCode errorCode;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
