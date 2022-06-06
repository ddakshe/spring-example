package com.example.spring.config.exception;

import com.example.spring.config.exception.response.ErrorResponse;
import com.example.spring.config.exception.response.MethodArgumentNotValidResponse;
import com.example.spring.config.exception.response.NoHandlerFoundResponse;
import com.example.spring.config.exception.response.ResourceNotFoundResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice   // RestController 의 모든 Exception 처리 담당
@Slf4j
public class GlobalExceptionHandler {

    /* @Valid RequestBody 의 값이 유효하지 않는 경우 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        final ErrorResponse response = new MethodArgumentNotValidResponse(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /* 잘못된 URL 로 요청 보냈을 경우 */
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<?> noHandlerFoundException(NoHandlerFoundException e){
        final ErrorResponse response = new NoHandlerFoundResponse(ErrorCode.NO_HANDLER_FOUND, e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e){
        final ResourceNotFoundResponse response = new ResourceNotFoundResponse(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}