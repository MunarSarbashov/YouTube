package com.example.YouTube.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoRequest {
    private String title;
    private String description;
    private String url;
    private Long userId;
}
