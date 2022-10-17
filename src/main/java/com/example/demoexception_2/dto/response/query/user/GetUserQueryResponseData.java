package com.example.demoexception_2.dto.response.query.user;

import com.example.demoexception_2.model.user.AddUserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetUserQueryResponseData extends QueryResponseData {
    private AddUserDTO addUserDTO;
}
