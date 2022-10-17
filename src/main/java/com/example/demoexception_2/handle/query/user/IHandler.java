package com.example.demoexception_2.handle.query.user;

import com.example.demoexception_2.dto.request.query.user.RequestData;
import com.example.demoexception_2.dto.response.query.user.ResponseData;

public interface IHandler <T extends RequestData, I extends ResponseData> {
    I handle(T request);
}
