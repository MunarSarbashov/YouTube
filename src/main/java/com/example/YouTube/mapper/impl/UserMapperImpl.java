package com.example.YouTube.mapper.impl;


import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public List<UserResponse> toDtoS(List<User> all) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : all) {
            userResponses.add(toDto(user));
        }
        return userResponses;
    }

    public UserResponse toDto(User user) {
        return new UserResponse(user.getId(), user.getNickname(), user.getEmail(), user.getVideos()!=null?user.getVideos().size():0L);
    }
}
