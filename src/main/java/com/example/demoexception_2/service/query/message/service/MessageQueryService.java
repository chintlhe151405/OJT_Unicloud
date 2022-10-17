package com.example.demoexception_2.service.query.message.service;

import com.example.demoexception_2.dto.message.GetMessageQuery;
import com.example.demoexception_2.dto.message.GetMessageResult;
import com.example.demoexception_2.dto.request.query.message.MessageQueryRequestData;
import com.example.demoexception_2.dto.response.query.message.MessageQueryResponseData;
import com.example.demoexception_2.model.message.Message;

import java.util.List;

public interface MessageQueryService {
    public List<Message> getAllMessages();
    public Message getMessageById(int messageId);

    GetMessageResult getMessage(GetMessageQuery query);
}
