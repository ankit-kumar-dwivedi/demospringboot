package com.example.demoapi.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T>  implements Serializable {

    private String statusCode;
    private String message;
    private T data;

    public CommonResponse(String statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public CommonResponse() {
        this.statusCode = "200";
        this.message="Success";
    }

    public CommonResponse(T data) {
        this.statusCode = "200";
        this.message="Success";
        this.data = data;
    }

    public CommonResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}