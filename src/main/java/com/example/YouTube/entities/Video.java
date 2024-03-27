package com.example.YouTube.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long views;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> likedUsers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> dislikedUsers;
    private LocalDateTime uploadDate;

    @ManyToOne
    private User user;

}
