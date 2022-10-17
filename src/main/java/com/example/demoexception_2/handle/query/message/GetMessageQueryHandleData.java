package com.example.demoexception_2.handle.query.message;

import com.example.demoexception_2.dto.request.query.message.MessageQueryRequestData;
import com.example.demoexception_2.dto.response.ResponseCode;
import com.example.demoexception_2.dto.response.query.message.MessageQueryResponseData;
import com.example.demoexception_2.exception.CustomException;
import com.example.demoexception_2.handle.query.user.QueryHandler;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.repository.query.message.MessageQueryRepository;
import com.example.demoexception_2.service.query.message.service.MessageQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetMessageQueryHandleData extends QueryHandler<MessageQueryRequestData, MessageQueryResponseData> {
    private final MessageQueryService messageQueryService;

    private final MessageQueryRepository messageQueryRepository;

    @Override
    public MessageQueryResponseData handle(MessageQueryRequestData request) {
        //check id exist
        Optional<Message> messageOptional = messageQueryRepository.findById(request.getId());
        if (!messageOptional.isPresent()){
            throw new CustomException(ResponseCode.NOT_FOUND.getCode(),null, "Id doesn't exist!");
        }
        Message message = messageQueryService.getMessageById(request.getId());
        return new MessageQueryResponseData(message);
    }
}
