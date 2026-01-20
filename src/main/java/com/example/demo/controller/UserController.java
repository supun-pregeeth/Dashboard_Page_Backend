package com.example.demo.controller;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.dto.UserSignupDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController //mapping request as an object
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") // your React frontend
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    //UserSignupDto dto = new UserSignupDto("spun123", "supun@gmail.com", "mypassword");
    @PostMapping("/signup")
    public UserResponseDto signup(@Valid @RequestBody UserSignupDto dto) { //“@RequestBody automatically convert it into a Java object.
        return userService.signup(dto); // controller calls the service method and returns its result
    }

    @PostMapping("/login")
    public UserResponseDto login(@Valid @RequestBody UserLoginDTO dto){

        return userService.login(dto);
    }

}
