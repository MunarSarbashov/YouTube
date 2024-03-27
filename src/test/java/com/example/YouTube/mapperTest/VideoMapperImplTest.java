package com.example.YouTube.mapperTest;


import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.entities.User;
import com.example.YouTube.entities.Video;
import com.example.YouTube.mapper.impl.VideoMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoMapperImplTest {

    private VideoMapperImpl videoMapper;

    @BeforeEach
    public void init() {
        videoMapper = new VideoMapperImpl();
    }

    @Test
    public void toDtoS_ReturnsVideoResponseList() {
        // Arrange
        User user = new User();
        user.setNickname("testNickname");

        Video video1 = new Video();
        video1.setId(1L);
        video1.setTitle("Video 1");
        video1.setUser(user);

        Video video2 = new Video();
        video2.setId(2L);
        video2.setTitle("Video 2");
        video2.setUser(user);

        List<Video> videos = Arrays.asList(video1, video2);

        // Act
        List<VideoResponse> result = videoMapper.toDtoS(videos);

        // Assert
        assertEquals(videos.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(videos.get(i).getId(), result.get(i).getId());
            assertEquals(videos.get(i).getTitle(), result.get(i).getTitle());
            assertEquals(videos.get(i).getUser().getNickname(), result.get(i).getNickname());
        }
    }
}