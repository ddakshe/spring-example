package com.example.spring.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final Long resourceId;
    private final String resourceName;
    public ResourceNotFoundException(ErrorCode errorCode, String resourceName, Long resourceId) {
        super(errorCode.getMessage());
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }
}
