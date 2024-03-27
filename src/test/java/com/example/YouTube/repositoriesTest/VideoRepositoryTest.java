package com.example.YouTube.repositoriesTest;

import com.example.YouTube.entities.Video;
import com.example.YouTube.repositories.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
public class VideoRepositoryTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private TestEntityManager entityManager;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenFindAll_thenReturnVideoList() {
        // given
        Video video = new Video();
        video.setTitle("Test Video");

        when(entityManager.persist(video)).thenReturn(video);
        entityManager.flush();

        when(videoRepository.findAll()).thenReturn(List.of(video));

        // when
        List<Video> found = videoRepository.findAll();

        // then
        assertNotNull(found);
        assertEquals(1, found.size());
        assertEquals(video.getTitle(), found.get(0).getTitle());
    }
}