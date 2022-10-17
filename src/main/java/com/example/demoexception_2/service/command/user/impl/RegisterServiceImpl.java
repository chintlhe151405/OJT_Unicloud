package com.example.demoexception_2.service.command.user.impl;

import com.example.demoexception_2.config.KeycloakConfig;
import com.example.demoexception_2.dto.request.command.user.RegisterCommandRequestData;
import com.example.demoexception_2.dto.response.command.user.RegisterCommandResponseData;
import com.example.demoexception_2.model.user.UserDTO;
import com.example.demoexception_2.service.command.user.service.RegisterService;
import com.example.demoexception_2.utils.Credentials;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Override
    public RegisterCommandResponseData addUser(RegisterCommandRequestData request) {
        UserDTO userDTO = request.getUserDTO();
        CredentialRepresentation credential = Credentials.createPasswordCredentials(userDTO.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);

        UsersResource instance = getInstance();
        RealmResource realmResource = getInstanceRealm();
        //get realm role "user"
        RoleRepresentation userRealmRole = realmResource.roles().get("user").toRepresentation();
        //create user manage-user with role
        Response response =  instance.create(user);
        //get user_id
        String userId = CreatedResponseUtil.getCreatedId(response);

        UserResource userResource = instance.get(userId);
        //gán realm role sang role user
        userResource.roles().realmLevel().add(Arrays.asList(userRealmRole));

        RegisterCommandResponseData commandResponseData = new RegisterCommandResponseData("Add Successfull!");

        return commandResponseData;
    }

    @Override
    public UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.realm).users();
    }

    @Override
    public RealmResource getInstanceRealm() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.realm);
    }
}
