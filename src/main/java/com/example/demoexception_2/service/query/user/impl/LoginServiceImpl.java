package com.example.demoexception_2.service.query.user.impl;

import com.example.demoexception_2.dto.request.query.user.LoginQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.LoginQueryResponseData;
import com.example.demoexception_2.service.query.user.service.LoginService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service

public class LoginServiceImpl implements LoginService {
    @Override
    public LoginQueryResponseData login(LoginQueryRequestData request) {
      try {
            String username = request.getUsername();
            String password = request.getPassword();
            if (username == null || password == null) {
                return null;
            }
            Keycloak keycloak = KeycloakBuilder.builder()
                    .serverUrl("http://localhost:8080/")
                    .realm("SpringBootKeycloak")
                    .username(username)
                    .password(password)
                    .clientId("login-app")
                    .build();
            TokenManager tokenManager = keycloak.tokenManager();
            AccessTokenResponse accessToken = tokenManager.getAccessToken();
            LoginQueryResponseData loginQueryResponseData = new LoginQueryResponseData(
                    accessToken.getToken()
                    , accessToken.getExpiresIn()
                    , accessToken.getRefreshExpiresIn()
                    , accessToken.getRefreshToken()
                    , accessToken.getTokenType()
                    , accessToken.getNotBeforePolicy()
                    , accessToken.getSessionState()
                    , accessToken.getScope()
            );
            return loginQueryResponseData;
        } catch (Exception exception) {
        //   throw new ApplicationException(ResponseCode.NOT_AUTHORIZED.getCode(), "Login Failed!");
        }
        return null;
    }
}
