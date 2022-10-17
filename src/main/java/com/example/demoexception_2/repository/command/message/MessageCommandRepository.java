package com.example.demoexception_2.repository.command.message;

import com.example.demoexception_2.model.message.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCommandRepository extends CrudRepository<Message, Integer> {
    public Message save(Message message);
}
