package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class UserLoginDTO {

    @Email
    @NotBlank (message = "Username or Email is required")
    @Size (min = 3, max = 50, message = "Must be between 3 and 50 characters")
    private String email;

    @NotBlank (message = "Password is required")
    @Size (min = 6, max = 100, message = "Password must be at least 6 characters")
    private String password;
}

