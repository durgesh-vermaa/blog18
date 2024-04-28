package com.blogapp18.service;

import com.blogapp18.payload.PostDto;

import java.util.List;

public interface PostService {

    public PostDto  createPost(PostDto postDto);

    void deletePost(long id);
    List<PostDto> fetchAllPosts(int pageNo,int pageSize,String sortBy);


    List<PostDto> fetchAllPosts();
}
