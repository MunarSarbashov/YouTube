package com.example.YouTube.serviceTest;

import com.example.YouTube.dto.UserRequest;
import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.exception.BadRequestException;
import com.example.YouTube.mapper.UserMapper;
import com.example.YouTube.repositories.UserRepository;
import com.example.YouTube.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void registerUser_ExistingEmailAndNickname_ThrowsBadRequestException() {
        // Arrange
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@example.com");
        userRequest.setNickname("testNickname");

        when(userRepository.existsByEmail(userRequest.getEmail())).thenReturn(true);
        when(userRepository.existsByNickname(userRequest.getNickname())).thenReturn(true);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> userService.registerUser(userRequest));

        verify(userRepository, times(1)).existsByEmail(userRequest.getEmail());
        verify(userRepository, times(1)).existsByNickname(userRequest.getNickname());
    }

    @Test
    public void getAllUsers_ReturnsAllUsers() {
        // Arrange
        User user1 = new User();
        user1.setEmail("test1@example.com");
        user1.setNickname("testNickname1");

        User user2 = new User();
        user2.setEmail("test2@example.com");
        user2.setNickname("testNickname2");

        List<User> users = Arrays.asList(user1, user2);
        List<UserResponse> userResponses = Arrays.asList(new UserResponse(), new UserResponse());

        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.toDtoS(users)).thenReturn(userResponses);

        // Act
        List<UserResponse> result = userService.getAllUsers();

        // Assert
        assertEquals(userResponses.size(), result.size());
        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(1)).toDtoS(users);
    }
}