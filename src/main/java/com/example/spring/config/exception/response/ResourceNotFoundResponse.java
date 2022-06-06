package com.example.spring.config.exception.response;

import com.example.spring.config.exception.ResourceNotFoundException;
import lombok.Getter;

@Getter
public class ResourceNotFoundResponse {
    private final String entityName;
    private final Long resourceId;
    private final String resourceName;

    public ResourceNotFoundResponse(ResourceNotFoundException e) {
        this.entityName = e.getResourceName();
        this.resourceId = e.getResourceId();
        this.resourceName = e.getMessage();
    }
}
