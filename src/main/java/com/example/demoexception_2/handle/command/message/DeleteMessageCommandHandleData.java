package com.example.demoexception_2.handle.command.message;

import com.example.demoexception_2.dto.request.command.message.DeleteMessageCommandRequest;
import com.example.demoexception_2.dto.response.command.message.DeleteMessageCommandResponse;
import com.example.demoexception_2.handle.command.user.CommandHandler;
import com.example.demoexception_2.service.command.message.service.MessageCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteMessageCommandHandleData extends CommandHandler<DeleteMessageCommandRequest, DeleteMessageCommandResponse> {
    private final MessageCommandService messageCommandService;

    @Override
    public DeleteMessageCommandResponse handle(DeleteMessageCommandRequest request) {
        int id = request.getId();
        messageCommandService.deleteMessage(id);
        return new DeleteMessageCommandResponse("Delete Successful");
    }
}
