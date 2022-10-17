package com.example.demoexception_2.dto.response.command.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterCommandResponseData extends CommandResponseData {
    private String message;
}
