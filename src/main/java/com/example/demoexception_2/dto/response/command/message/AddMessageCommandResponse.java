package com.example.demoexception_2.dto.response.command.message;

import com.example.demoexception_2.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddMessageCommandResponse extends CommandResponseData{
    private String message;
}
