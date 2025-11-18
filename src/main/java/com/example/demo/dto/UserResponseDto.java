package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private Integer id;       // Unique ID of the user (nullable for messages)
    private String username;  // Username (nullable for messages)
    private String email;     // Email address (nullable for messages)
    private String message;   // Text message from backend

    // Constructor for simple message only
    public UserResponseDto(String message) {
        this.message = message;
    }

    // Constructor for full user info + message
    public UserResponseDto(Integer id, String username, String email, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.message = message;
    }
}
