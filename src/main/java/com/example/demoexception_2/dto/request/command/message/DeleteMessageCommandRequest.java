package com.example.demoexception_2.dto.request.command.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteMessageCommandRequest extends CommandRequestData{
    private int id;
}
