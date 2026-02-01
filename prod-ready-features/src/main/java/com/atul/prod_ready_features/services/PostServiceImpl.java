package com.atul.prod_ready_features.services;

import com.atul.prod_ready_features.dtos.PostDto;
import com.atul.prod_ready_features.entities.PostEntity;
import com.atul.prod_ready_features.exceptions.ResourceNotFoundException;
import com.atul.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> getAllPosts() {
         return postRepository.findAll().stream().
                 map(currPostEntity -> modelMapper.map(currPostEntity,PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto savePost(PostDto currPost) {

        PostEntity currPostEntity = modelMapper.map(currPost,PostEntity.class);
        return modelMapper.map(postRepository.save(currPostEntity), PostDto.class);

    }

    @Override
    public PostDto findPostById(Long postId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Posts","id",postId));
        return modelMapper.map(post, PostDto.class);
    }
}
