package com.example.demoexception_2.handle.command.user;

import com.example.demoexception_2.dto.request.command.user.RegisterCommandRequestData;
import com.example.demoexception_2.dto.response.command.user.RegisterCommandResponseData;
import com.example.demoexception_2.service.command.user.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class RegisterHandleKeycloak extends RegisterHandler<RegisterCommandRequestData, RegisterCommandResponseData> {
    private final RegisterService registerService;

    @Override
    public RegisterCommandResponseData handle(RegisterCommandRequestData request) {
        return registerService.addUser(request);
    }
}
