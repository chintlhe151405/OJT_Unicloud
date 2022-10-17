package com.example.demoexception_2.dto.response.query.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class LoginQueryResponseData extends QueryResponseData {
    private String access_token;
    private long expires_in;
    private long refresh_expires_in;
    private String refresh_token;
    private String token_type;
    private int not_before_policy;
    private String session_state;
    private String scope;

}
