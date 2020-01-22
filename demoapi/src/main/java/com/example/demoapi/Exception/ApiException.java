package com.example.demoapi.Exception;

public class ApiException extends RuntimeException {

    private String reasonCode;

    public ApiException(String reasonCode, String message) {
        super(message);
        this.reasonCode = message;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
}
