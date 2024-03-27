package com.example.YouTube.controller;

import com.example.YouTube.dto.VideoRequest;
import com.example.YouTube.dto.VideoResponse;
import com.example.YouTube.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    @PostMapping("/add")
    public void uploadVideo(@RequestBody VideoRequest videoRequest){
        videoService.uploadVideo(videoRequest);
    }
    @GetMapping("/allVideos")
    public List<VideoResponse> getAllVideos(){
        return videoService.getAllVideos();
    }
    @GetMapping("/watch/{videoId}/{userId}")
    public void watchVideo(@PathVariable Long videoId, @PathVariable Long userId){
        videoService.watchVideo(videoId, userId);
    }
    @PostMapping("/like/{videoId}/{userId}")
    public void likeVideo(@PathVariable Long videoId, @PathVariable Long userId){
        videoService.likeVideo(videoId, userId);
    }
}
