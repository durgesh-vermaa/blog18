package com.blogapp18.service.impl;

import com.blogapp18.entity.Post;
import com.blogapp18.payload.PostDto;
import com.blogapp18.repository.PostRepository;
import com.blogapp18.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;


    public ServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {

        this.postRepository = postRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post =  mapToEntity(postDto);
        Post savedPost = postRepository.save(post);

       PostDto dto = mapToDto(savedPost);
        return   dto;
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> fetchAllPosts(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDto = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostDto> fetchAllPosts() {
        List<Post> post = postRepository.findAll();
        List<PostDto> postDto = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;


    }

    private PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return  dto;

    }
}
