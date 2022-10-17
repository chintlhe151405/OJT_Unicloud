package com.example.demoexception_2.dto.response;

import com.example.demoexception_2.dto.response.query.user.ResponseData;
import lombok.Getter;


@Getter
public class ErrorResponse extends BaseResponse {

    private PopupResponseData popupResponseData;


    public ErrorResponse(String responseCode, ResponseData responseData, String message) {
        super(responseCode, responseData, message);
    }
}
