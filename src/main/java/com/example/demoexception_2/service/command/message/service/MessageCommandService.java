package com.example.demoexception_2.service.command.message.service;

import com.example.demoexception_2.model.message.Message;

public interface MessageCommandService {
    public void addMessage(Message message);
    public void deleteMessage(int messageId);
    public void updateMessage(int messageId, Message message);
}
