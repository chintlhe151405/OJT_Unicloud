package com.example.demoexception_2.repository.redis.message;

import com.example.demoexception_2.constants.RedisConstants;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class MessageRedisRepository implements RedisRepository<Integer, Message>{
    private final RedisTemplate redisTemplate;
    @Override
    public Message get(Integer key) {
        return (Message) redisTemplate.opsForValue().get(RedisConstants.MESSAGE_KEY + StringUtils.COLON_CHARACTER + key);
    }

    @Override
    public void delete(Integer key) {
        redisTemplate.delete(RedisConstants.MESSAGE_KEY + StringUtils.COLON_CHARACTER + key);
    }


    @Override
    public void put(Message value) {
        redisTemplate.opsForValue().set(RedisConstants.MESSAGE_KEY + StringUtils.COLON_CHARACTER + value.getMessageId(), value);
    }
}
