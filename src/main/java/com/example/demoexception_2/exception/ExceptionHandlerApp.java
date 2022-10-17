package com.example.demoexception_2.exception;

import com.example.demoexception_2.dto.response.BaseResponse;
import com.example.demoexception_2.dto.response.ResponseCode;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerApp {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<BaseResponse> handle(CustomException ex) {
            BaseResponse response = new BaseResponse(ResponseCode.NOT_FOUND.getCode(), null, "ID doesn't exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
