package com.example.YouTube.mapper;

import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.entities.Video;

import java.util.List;

public interface VideoMapper {
    List<VideoResponse> toDtoS(List<Video> all);
}
