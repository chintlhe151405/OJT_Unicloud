package com.example.demoexception_2.dto.request.query.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserQueryRequestData extends QueryRequestData {
    private String userId;
}
