package com.example.demoexception_2.service.query.user.impl;

import com.example.demoexception_2.dto.request.query.user.GetUserQueryRequestData;
import com.example.demoexception_2.dto.response.query.user.GetUserQueryResponseData;
import com.example.demoexception_2.model.user.AddUserDTO;
import com.example.demoexception_2.service.query.user.service.UserInforService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class UserInforServiceImpl implements UserInforService {
    @Override
    public GetUserQueryResponseData getUserInfor(GetUserQueryRequestData request) {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        final Principal principal = (Principal) authentication.getPrincipal();
        String userIdByToken = request.getUserId();
        userIdByToken = getUserId();
        if (!(principal instanceof KeycloakPrincipal)) {
            return new GetUserQueryResponseData();
        }
        KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;

        return createResponse(userIdByToken, kPrincipal);
    }

    @Override
    public GetUserQueryResponseData createResponse(String userId, KeycloakPrincipal<KeycloakSecurityContext> kPrincipal) {
        IDToken token = kPrincipal.getKeycloakSecurityContext()
                .getIdToken();
        AddUserDTO addUserDTO = new AddUserDTO();
        Map<String, Object> customClaims = token.getOtherClaims();
        if (customClaims.containsKey("DOB")) {
            addUserDTO.setDob((String) customClaims.get("DOB"));
        }
        if (customClaims.containsKey("Gmail")) {
            addUserDTO.setEmail((String) customClaims.get("Gmail"));
        }
        if (customClaims.containsKey("FirstName")) {
            addUserDTO.setFirstname((String) customClaims.get("FirstName"));
        }
        if (customClaims.containsKey("LastName")) {
            addUserDTO.setLastname((String) customClaims.get("LastName"));
        }
        return new GetUserQueryResponseData(addUserDTO);
    }

    @Override
    public String getUserId() {
        KeycloakAuthenticationToken authentication =
                (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Principal principal = (Principal) authentication.getPrincipal();

        String userIdByToken = "";

        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
            userIdByToken = token.getSubject();
        }
        return userIdByToken;
    }
}
