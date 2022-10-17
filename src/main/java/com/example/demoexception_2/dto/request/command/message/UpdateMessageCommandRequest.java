package com.example.demoexception_2.dto.request.command.message;

import com.example.demoexception_2.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UpdateMessageCommandRequest extends CommandRequestData{
    private int id;
    private Message message;
}
