package com.example.spring.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SuccessResponseBody<T>{
    private Long createdId;
    private T result;
}
