package com.example.demoexception_2.dto.request.command.user;

import com.example.demoexception_2.model.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCommandRequestData extends CommandRequestData {
    private UserDTO userDTO;
}
