package com.example.YouTube.mapperTest;

import com.example.YouTube.dto.UserRequest;
import com.example.YouTube.exception.BadRequestException;
import com.example.YouTube.repositories.UserRepository;
import com.example.YouTube.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.example.YouTube.dto.UserResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.mapper.impl.UserMapperImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class UserMapperImplTest {

    private UserMapperImpl userMapper = new UserMapperImpl();




    @Test
    public void toDtoSTest() {
        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("test1@example.com");
        user1.setNickname("test1");
        user1.setVideos(null);

        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("test2@example.com");
        user2.setNickname("test2");
        user2.setVideos(null);

        List<User> users = Arrays.asList(user1, user2);

        List<UserResponse> userResponses = userMapper.toDtoS(users);

        assertEquals(users.size(), userResponses.size());
        for (int i = 0; i < users.size(); i++) {
            assertEquals(users.get(i).getId(), userResponses.get(i).getId());
            assertEquals(users.get(i).getEmail(), userResponses.get(i).getEmail());
            assertEquals(users.get(i).getNickname(), userResponses.get(i).getNickname());
            assertEquals(0L, userResponses.get(i).getVideoCount());
        }
    }

    @Test
    public void toDtoTest() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setNickname("test");
        user.setVideos(null);

        UserResponse userResponse = userMapper.toDto(user);

        assertEquals(user.getId(), userResponse.getId());
        assertEquals(user.getEmail(), userResponse.getEmail());
        assertEquals(user.getNickname(), userResponse.getNickname());
        assertEquals(0L, userResponse.getVideoCount());
    }
}