package com.atul.prod_ready_features.services;

import com.atul.prod_ready_features.dtos.PostDto;
import com.atul.prod_ready_features.entities.PostEntity;

import java.util.List;

public interface PostService {

       List<PostDto> getAllPosts();

       PostDto savePost(PostDto currPost);

    PostDto findPostById(Long postId);
}
