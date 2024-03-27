package com.example.YouTube.repositories;

import com.example.YouTube.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
}
