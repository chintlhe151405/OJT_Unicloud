package com.example.demoexception_2.dto.response;

import lombok.AllArgsConstructor;

public enum ResponseCode {

    NOT_FOUND("404"), BAD_REQUEST("400"), NOT_AUTHORIZED("401"),
    CREATED("201"), OK("200"), NOT_IMPLEMENT("501"),
    INTERNAL_SERVER_ERROR("500"), FORBIDDEN("403");
    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
