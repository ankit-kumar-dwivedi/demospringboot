package com.example.demoapi.Advice;

import com.example.demoapi.Exception.ApiException;
import com.example.demoapi.Response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<CommonResponse<?>> handleException(ApiException e) {
        return new ResponseEntity<CommonResponse<?>>(new CommonResponse<>(e.getReasonCode(), e.getMessage(), null), HttpStatus.OK);
    }

    @ExceptionHandler(value = {ExecutionException.class, InterruptedException.class})
    protected ResponseEntity<CommonResponse<Object>> secondhandleException() {
        return new ResponseEntity<CommonResponse<Object>>(new CommonResponse<Object>("400", "API failed", null), HttpStatus.OK);
    }}
