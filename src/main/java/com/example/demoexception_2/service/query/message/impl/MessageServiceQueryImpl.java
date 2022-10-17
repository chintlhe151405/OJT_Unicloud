package com.example.demoexception_2.service.query.message.impl;

import com.example.demoexception_2.dto.message.GetMessageQuery;
import com.example.demoexception_2.dto.message.GetMessageResult;
import com.example.demoexception_2.exception.CustomException;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.model.message.MessageRedis;
import com.example.demoexception_2.repository.query.message.MessageQueryRepository;
import com.example.demoexception_2.service.query.message.service.MessageQueryService;
import com.example.demoexception_2.service.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceQueryImpl implements MessageQueryService {
    private final MessageQueryRepository messageQueryRepository;
    private final RedisService<MessageRedis,Message> redisService;

    @Override
    public List<Message> getAllMessages() {
        return messageQueryRepository.findAllBy();
    }

    @Override
    public Message getMessageById(int messageId) {
        Message message = redisService.get(new MessageRedis(messageId));
        if(message != null)
            return message;
        message = messageQueryRepository.findMessageByMessageId(messageId);
        if(message == null){
            throw new CustomException();
        }
        redisService.put(message);
        return message;
    }

    @Override
    public GetMessageResult getMessage(GetMessageQuery query) {
        return null;
    }


}
