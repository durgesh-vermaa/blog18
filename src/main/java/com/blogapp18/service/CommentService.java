package com.blogapp18.service;

import com.blogapp18.entity.Comment;
import com.blogapp18.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,long postId);


}
