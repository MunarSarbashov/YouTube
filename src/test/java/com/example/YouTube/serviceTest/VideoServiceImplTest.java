package com.example.YouTube.serviceTest;


import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.entities.Video;
import com.example.YouTube.exception.NotFoundException;
import com.example.YouTube.mapper.VideoMapper;
import com.example.YouTube.repositories.UserRepository;
import com.example.YouTube.repositories.VideoRepository;
import com.example.YouTube.service.impl.VideoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class VideoServiceImplTest {

    @InjectMocks
    private VideoServiceImpl videoService;

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VideoMapper videoMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void uploadVideo_UserNotFound_ThrowsNotFoundException() {
        // Arrange
        VideoRequest videoRequest = new VideoRequest();
        videoRequest.setUserId(1L);

        when(userRepository.findById(videoRequest.getUserId())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> videoService.uploadVideo(videoRequest));

        verify(userRepository, times(1)).findById(videoRequest.getUserId());
    }

    @Test
    public void getAllVideos_ReturnsAllVideos() {
        // Arrange
        Video video1 = new Video();
        video1.setTitle("Video 1");

        Video video2 = new Video();
        video2.setTitle("Video 2");

        List<Video> videos = Arrays.asList(video1, video2);
        List<VideoResponse> videoResponses = Arrays.asList(new VideoResponse(), new VideoResponse());

        when(videoRepository.findAll()).thenReturn(videos);
        when(videoMapper.toDtoS(videos)).thenReturn(videoResponses);

        // Act
        List<VideoResponse> result = videoService.getAllVideos();

        // Assert
        assertEquals(videoResponses.size(), result.size());
        verify(videoRepository, times(1)).findAll();
        verify(videoMapper, times(1)).toDtoS(videos);
    }
}