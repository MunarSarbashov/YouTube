package com.example.YouTube.service.impl;

import com.example.YouTube.dto.UserRequest;
import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.exception.BadRequestException;
import com.example.YouTube.mapper.UserMapper;
import com.example.YouTube.repositories.UserRepository;
import com.example.YouTube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail()) && userRepository.existsByNickname(userRequest.getNickname())){
            throw new BadRequestException("Email/Nickname already exists");
        }
        User user = new  User();
        user.setEmail(userRequest.getEmail());
        user.setNickname(userRequest.getNickname());
        userRepository.save(user);

    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toDtoS(userRepository.findAll());
    }
}
