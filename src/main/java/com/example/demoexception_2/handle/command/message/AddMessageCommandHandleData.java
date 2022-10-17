package com.example.demoexception_2.handle.command.message;

import com.example.demoexception_2.dto.request.command.message.AddMessageCommandRequest;
import com.example.demoexception_2.dto.response.command.message.AddMessageCommandResponse;
import com.example.demoexception_2.handle.command.user.CommandHandler;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.service.command.message.service.MessageCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddMessageCommandHandleData extends CommandHandler<AddMessageCommandRequest, AddMessageCommandResponse> {
    private final MessageCommandService messageCommandService;

    @Override
    public AddMessageCommandResponse handle(AddMessageCommandRequest request) {
        Message message = request.getMessage();
        messageCommandService.addMessage(message);
        return new AddMessageCommandResponse("Add Successful");
    }
}
