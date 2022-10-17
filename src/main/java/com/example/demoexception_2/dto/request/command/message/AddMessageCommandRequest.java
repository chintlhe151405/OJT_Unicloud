package com.example.demoexception_2.dto.request.command.message;

import com.example.demoexception_2.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class AddMessageCommandRequest extends CommandRequestData{
    private Message message;

}
