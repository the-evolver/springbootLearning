package com.atul.prod_ready_features.controllers;

import com.atul.prod_ready_features.dtos.PostDto;
import com.atul.prod_ready_features.services.PostService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    List<PostDto> getAllPosts(){
        return postService.getAllPosts();

    }

    @PostMapping
    PostDto savePosts(@RequestBody PostDto currPost){
        return postService.savePost(currPost);
    }

    @GetMapping(path = "/{id}")
    PostDto findPostById(@PathVariable(value = "id") String postId){
        System.out.println(postId);
        return postService.findPostById(Long.valueOf(postId));

    }
}
