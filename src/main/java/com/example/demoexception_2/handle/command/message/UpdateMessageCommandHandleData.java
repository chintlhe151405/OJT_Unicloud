package com.example.demoexception_2.handle.command.message;

import com.example.demoexception_2.dto.request.command.message.UpdateMessageCommandRequest;
import com.example.demoexception_2.dto.response.ResponseCode;
import com.example.demoexception_2.dto.response.command.message.UpdateMessageCommandResponse;
import com.example.demoexception_2.exception.CustomException;
import com.example.demoexception_2.handle.command.user.CommandHandler;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.repository.query.message.MessageQueryRepository;
import com.example.demoexception_2.service.command.message.service.MessageCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UpdateMessageCommandHandleData extends CommandHandler<UpdateMessageCommandRequest, UpdateMessageCommandResponse> {

    private final MessageCommandService messageCommandService;

    private final MessageQueryRepository messageQueryRepository;

    @Override
    public UpdateMessageCommandResponse handle(UpdateMessageCommandRequest request) {
        Message message1 = messageQueryRepository.findMessageByMessageId(request.getId());
        Optional<Message> categoryOptional = messageQueryRepository.findById(request.getMessage().getMessageId());
        if(!categoryOptional.isPresent()){
            throw new CustomException(ResponseCode.NOT_FOUND.getCode(), "Id doesn't exist!");
        }
        categoryOptional.map(category1 -> {
            message1.setMessageId(category1.getMessageId());
            return null;
        });
        int id = request.getId();
        Message message = request.getMessage();
        messageCommandService.updateMessage(id, message);
        return new UpdateMessageCommandResponse("Update Successful");
    }
}
