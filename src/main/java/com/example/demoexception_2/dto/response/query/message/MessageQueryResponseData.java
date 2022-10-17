package com.example.demoexception_2.dto.response.query.message;

import com.example.demoexception_2.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MessageQueryResponseData extends QueryResponseData{
    private Message  message;
}
