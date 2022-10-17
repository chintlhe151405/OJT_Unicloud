package com.example.demoexception_2.dto.response;

import com.example.demoexception_2.dto.response.query.user.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T extends ResponseData> {

    private String responseCode;

    private T responseData;

    private String message;

}
