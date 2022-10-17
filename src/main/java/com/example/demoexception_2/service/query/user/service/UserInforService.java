package com.example.demoexception_2.service.query.user.service;

import com.example.demoexception_2.dto.request.query.user.GetUserQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.GetUserQueryResponseData;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

public interface UserInforService {
    public GetUserQueryResponseData getUserInfor(GetUserQueryRequestData request);

    public GetUserQueryResponseData createResponse(String userId, KeycloakPrincipal<KeycloakSecurityContext> kPrincipal);

    public String getUserId();
}
