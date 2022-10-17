package com.example.demoexception_2.service.command.message.impl;

import com.example.demoexception_2.dto.response.ResponseCode;
import com.example.demoexception_2.exception.CustomException;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.model.message.MessageRedis;
import com.example.demoexception_2.repository.command.message.MessageCommandRepository;
import com.example.demoexception_2.repository.query.message.MessageQueryRepository;
import com.example.demoexception_2.service.command.message.service.MessageCommandService;
import com.example.demoexception_2.service.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class MessageServiceCommandImpl implements MessageCommandService{
    private final MessageCommandRepository messageCommandRepository;
    private final RedisService<MessageRedis,Message> redisService;

    @Override
    public void addMessage(Message message) {
        messageCommandRepository.save(message);
        redisService.put(message);
    }
    @Override
    public void deleteMessage(int messageId) {
        redisService.delete(new MessageRedis(messageId));
        messageCommandRepository.deleteById(messageId);
    }
    @Override
    public void updateMessage(int messageId, Message message) {
        redisService.put(message);
        messageCommandRepository.save(message);
    }
}
