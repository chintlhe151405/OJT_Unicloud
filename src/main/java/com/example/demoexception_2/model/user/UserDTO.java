package com.example.demoexception_2.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
