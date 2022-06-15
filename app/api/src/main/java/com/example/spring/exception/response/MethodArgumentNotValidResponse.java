package com.example.spring.exception.response;

import com.example.spring.exception.ErrorCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MethodArgumentNotValidResponse extends ErrorResponse {

    private final List<FieldErrorInfo> fieldErrors;

    public MethodArgumentNotValidResponse(ErrorCode errorCode, BindingResult bindingResult) {
        super(errorCode);
        this.fieldErrors = getFieldErrors(bindingResult);
    }

    private static List<FieldErrorInfo> getFieldErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(FieldErrorInfo::new).collect(Collectors.toList());
    }

    @Getter
    private static class FieldErrorInfo {
        private final String fieldName;
        private final Object inputValue;
        private final String message;
        private final String objectName;

        public FieldErrorInfo(FieldError fieldError) {
            this.fieldName = fieldError.getField();
            this.inputValue = fieldError.getRejectedValue();
            this.message = fieldError.getDefaultMessage();
            this.objectName = fieldError.getObjectName();
        }
    }

}
