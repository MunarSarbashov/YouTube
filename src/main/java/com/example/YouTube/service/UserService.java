package com.example.YouTube.service;

import com.example.YouTube.dto.UserRequest;
import com.example.YouTube.dto.UserResponse;

import java.util.List;

public interface UserService {
    void registerUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();
}
