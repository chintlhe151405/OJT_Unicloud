package com.example.demoexception_2.handle.query.user;

import com.example.demoexception_2.dto.request.query.user.LoginQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.LoginQueryResponseData;
import com.example.demoexception_2.service.query.user.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginHandleKeycloak extends LoginHandler<LoginQueryRequestData, LoginQueryResponseData>{
    private  LoginService loginService;

    public LoginHandleKeycloak() {
    }

    @Override
    public LoginQueryResponseData handle(LoginQueryRequestData request) {
        return loginService.login(request);
    }

}
