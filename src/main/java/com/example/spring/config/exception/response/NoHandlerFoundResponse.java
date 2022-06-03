package com.example.spring.config.exception.response;

import com.example.spring.config.exception.ErrorCode;
import lombok.Getter;
import org.springframework.web.servlet.NoHandlerFoundException;

@Getter
public class NoHandlerFoundResponse extends ErrorResponse {

    private final String httpMethod;
    private final String requestURL;
    private final String message;

    public NoHandlerFoundResponse(ErrorCode errorCode, NoHandlerFoundException e) {
        super(errorCode);
        this.httpMethod = e.getHttpMethod();
        this.requestURL = e.getRequestURL();
        this.message = e.getMessage();
    }
}
