package com.example.YouTube.service;

import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;

import java.util.List;

public interface VideoService {
    void uploadVideo(VideoRequest videoRequest);

    List<VideoResponse> getAllVideos();

    void watchVideo(Long videoId, Long userId);

    void likeVideo(Long videoId, Long userId);
}
