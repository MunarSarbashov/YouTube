package com.example.YouTube.mapper.impl;

import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.entities.Video;
import com.example.YouTube.mapper.VideoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VideoMapperImpl implements VideoMapper {
    @Override
    public List<VideoResponse> toDtoS(List<Video> all) {
        List<VideoResponse> videoResponses = new ArrayList<>();
        for (Video video : all) {
            videoResponses.add(toDto(video));
        }
        return videoResponses;
    }

    private VideoResponse toDto(Video video) {
        VideoResponse response = new VideoResponse();
        response.setId(video.getId());
        response.setTitle(video.getTitle());
        response.setDescription(video.getDescription());
        response.setUrl(video.getUrl());
        response.setViews(video.getViews());
        response.setLikes(video.getLikedUsers()!= null? video.getLikedUsers().size() : 0L);
        response.setDislikes(video.getDislikedUsers()!= null? video.getDislikedUsers().size() : 0L);
        response.setUploadDate(video.getUploadDate());
        response.setNickname(video.getUser().getNickname());
        return response;
    }
}
