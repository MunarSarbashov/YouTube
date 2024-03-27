package com.example.YouTube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponse {
    private Long id;
    private String nickname;
    private String email;
    private Long videoCount;
}
