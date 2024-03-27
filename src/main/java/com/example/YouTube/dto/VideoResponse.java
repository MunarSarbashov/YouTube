package com.example.YouTube.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VideoResponse {
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long userId;
    private String nickname;
    private Long likes;
    private Long dislikes;
    private Long views;
    private LocalDateTime uploadDate;
}
