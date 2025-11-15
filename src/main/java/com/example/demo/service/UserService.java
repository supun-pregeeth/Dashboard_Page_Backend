package com.example.demo.service;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.dto.UserSignupDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDto signup(@Valid UserSignupDto dto) {

        // Check if email already exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            return new UserResponseDto("Email is already registered");
        }

        // Check if username already exists
        if (userRepository.existsByUsername(dto.getUsername())) {
            return new UserResponseDto("Username is already taken");
        }

        // Create new user
        User user = new User(dto.getUsername(), dto.getEmail(), dto.getPassword());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            // Log the error and return a safe message
            e.printStackTrace();
            return new UserResponseDto("Error saving user: " + e.getMessage());
        }

        // ✅ Return user info + success message
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), " User registered successfully");
    }

    @Transactional(readOnly = true)
    public UserResponseDto login(@Valid UserLoginDTO dto){

        //isPresent() - Checks if value exists
        //isEmpty() - Checks if empty
        //get() - Returns the value (only if present)
        //ifPresent() - Executes a block if value exists
        //orElse() - Returns value or a default
        //orElseThrow()- Throws exception if value missing

        Optional<User> optinalUser = userRepository.findByEmail(dto.getEmail());

        if(optinalUser.isEmpty()){
            return new UserResponseDto("Invalid email or password");
        }

        User user = optinalUser.get(); //means you are getting the User object stored inside optionalUser

        // ✅ Password check
        if(!dto.getPassword().equals(user.getPassword())){
            return new UserResponseDto("Invalid email or password");
        }

        return new UserResponseDto("Login successful") ;


    }
}
