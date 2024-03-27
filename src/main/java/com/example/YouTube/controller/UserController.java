package com.example.YouTube.controller;

import com.example.YouTube.dto.UserRequest;
import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;;
    @PostMapping("/register")//TODO: change to /register
    public void registerUser(@RequestBody UserRequest request){
        userService.registerUser(request);
    }
    @GetMapping("/allUsers")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

}
