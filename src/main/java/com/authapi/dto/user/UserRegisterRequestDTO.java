package com.authapi.dto.user;

import com.authapi.entities.user.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterRequestDTO {

    @NotBlank(message = "Login is mandatory!")
    private String login;

    @NotBlank(message = "Password is mandatory!")
    private String password;

    @NotBlank(message = "Role is mandatory!")
    private UserRole role;

}
