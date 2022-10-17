package com.example.demoexception_2.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
@Data
public class AddUserDTO {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String dob;
}
