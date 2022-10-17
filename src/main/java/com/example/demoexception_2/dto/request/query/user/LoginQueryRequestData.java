package com.example.demoexception_2.dto.request.query.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class LoginQueryRequestData extends QueryRequestData{
    private String username;
    private String password;
}
