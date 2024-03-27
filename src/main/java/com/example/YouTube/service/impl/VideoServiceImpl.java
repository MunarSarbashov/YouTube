package com.example.YouTube.service.impl;

import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.entities.Video;
import com.example.YouTube.exception.NotFoundException;
import com.example.YouTube.mapper.VideoMapper;
import com.example.YouTube.repositories.UserRepository;
import com.example.YouTube.repositories.VideoRepository;
import com.example.YouTube.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;
    private final UserRepository userRepository;
    @Override
    public void uploadVideo(VideoRequest videoRequest) {
        Video video = new Video();
        video.setDescription(videoRequest.getDescription());
        video.setUrl(videoRequest.getUrl());
        video.setTitle(videoRequest.getTitle());
        video.setViews(0L);
        video.setUploadDate(LocalDateTime.now());
        Optional<User> user = userRepository.findById(videoRequest.getUserId());
        if (user.isEmpty())
            throw new NotFoundException("User not found", HttpStatus.NOT_FOUND);
        video.setUser(user.get());
        videoRepository.save(video);

    }

    @Override
    public List<VideoResponse> getAllVideos() {
        return videoMapper.toDtoS(videoRepository.findAll());
    }

    @Override
    public void watchVideo(Long videoId, Long userId) {
        Optional<Video> video = videoRepository.findById(videoId);
        if (video.isEmpty())
            throw new NotFoundException("Video not found", HttpStatus.NOT_FOUND);
        Video video1 = video.get();
        video1.setViews(video1.getViews() + 1);
        videoRepository.save(video1);
    }

    @Override
    public void likeVideo(Long videoId, Long userId) {
        Optional<Video> video = videoRepository.findById(videoId);
        if (video.isEmpty())
            throw new NotFoundException("Video not found", HttpStatus.NOT_FOUND);
        Video video1 = video.get();
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException("User not found", HttpStatus.NOT_FOUND);
        User user1 = user.get();
        if (video1.getLikedUsers().contains(user1))
            video1.getLikedUsers().remove(user1);
        else
            video1.getLikedUsers().add(user1);
        videoRepository.save(video1);
    }
}
