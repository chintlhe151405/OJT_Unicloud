package com.example.demoexception_2.service.redis;

import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.model.message.MessageRedis;
import com.example.demoexception_2.repository.redis.message.MessageRedisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RedisServiceImpl implements RedisService<MessageRedis, Message>{

    private final  MessageRedisRepository messageRedisRepository;

    @Override
    public Message get(MessageRedis key) {
        return messageRedisRepository.get(key.getMessage_id());
    }

    @Override
    public void delete(MessageRedis key) {
        messageRedisRepository.delete(key.getMessage_id());
    }

    @Override
    public void put(Message value) {
        messageRedisRepository.put(value);
    }
}
