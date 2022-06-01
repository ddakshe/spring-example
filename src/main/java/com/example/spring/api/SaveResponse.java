package com.example.spring.api;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveResponse<T>{
    private Long createdId;
    private T result;
}
