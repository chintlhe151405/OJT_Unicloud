package com.example.demoexception_2.service.command.user.service;

import com.example.demoexception_2.dto.request.command.user.RegisterCommandRequestData;
import com.example.demoexception_2.dto.response.command.user.RegisterCommandResponseData;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

public interface RegisterService {
    public RegisterCommandResponseData addUser(RegisterCommandRequestData request);
    public UsersResource getInstance();
    public RealmResource getInstanceRealm();
}
