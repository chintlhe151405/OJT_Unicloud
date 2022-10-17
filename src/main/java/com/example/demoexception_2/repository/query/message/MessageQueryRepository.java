package com.example.demoexception_2.repository.query.message;

import com.example.demoexception_2.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface MessageQueryRepository extends JpaRepository<Message, Integer> {
    public Message findMessageByMessageId(int id);
    public List<Message> findAllBy();
}
