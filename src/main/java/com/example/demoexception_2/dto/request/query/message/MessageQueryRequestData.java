package com.example.demoexception_2.dto.request.query.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageQueryRequestData extends QueryRequestData{
    private int id;
}
