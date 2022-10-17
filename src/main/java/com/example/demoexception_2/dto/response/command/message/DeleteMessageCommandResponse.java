package com.example.demoexception_2.dto.response.command.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteMessageCommandResponse extends CommandResponseData{
    private String message;
}
