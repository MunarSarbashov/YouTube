package com.example.YouTube.mapper;

import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.entities.User;

import java.util.List;

public interface UserMapper {
    List<UserResponse> toDtoS(List<User> all);
}
