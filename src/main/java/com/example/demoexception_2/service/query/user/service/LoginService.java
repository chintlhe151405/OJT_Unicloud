package com.example.demoexception_2.service.query.user.service;

import com.example.demoexception_2.dto.request.query.user.LoginQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.LoginQueryResponseData;

public interface LoginService {
    public LoginQueryResponseData login(LoginQueryRequestData request);

}
