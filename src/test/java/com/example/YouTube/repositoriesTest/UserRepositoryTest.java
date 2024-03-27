package com.example.YouTube.repositoriesTest;

import com.example.YouTube.entities.User;
import com.example.YouTube.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DataJpaTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenExistsByEmail_thenReturnBoolean() {
        // given
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        // when
        Boolean exists = userRepository.existsByEmail(user.getEmail());

        // then
        assertTrue(exists);
    }

    @Test
    public void whenExistsByNickname_thenReturnBoolean() {
        // given
        User user = new User();
        user.setNickname("testNickname");

        when(userRepository.existsByNickname(user.getNickname())).thenReturn(true);

        // when
        Boolean exists = userRepository.existsByNickname(user.getNickname());

        // then
        assertTrue(exists);
    }
}