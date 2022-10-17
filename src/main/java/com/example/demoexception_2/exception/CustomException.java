package com.example.demoexception_2.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class CustomException extends RuntimeException{

    private String responseCode;
    private Object data;
    private String message;

    public CustomException(String responseCode, Object data, String message) {
        this.responseCode = responseCode;
        this.data = data;
        this.message = message;
    }

    public CustomException(String code, String s) {
    }
}
