package com.example.demoexception_2.handle.query.user;

import com.example.demoexception_2.dto.request.query.user.GetUserQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.GetUserQueryResponseData;
import com.example.demoexception_2.service.query.user.impl.UserInforServiceImpl;
import com.example.demoexception_2.service.query.user.service.UserInforService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserInforHandleKeycloak extends UserInforHandle<GetUserQueryRequestData, GetUserQueryResponseData> {
    private final UserInforService userInforService;

    @Override
    public GetUserQueryResponseData handle(GetUserQueryRequestData request) {
        return userInforService.getUserInfor(request);
    }

}
