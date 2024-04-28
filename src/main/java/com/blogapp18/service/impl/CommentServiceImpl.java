package com.blogapp18.service.impl;

import com.blogapp18.entity.Comment;
import com.blogapp18.entity.Post;
import com.blogapp18.payload.CommentDto;
import com.blogapp18.repository.CommentRepository;
import com.blogapp18.repository.PostRepository;
import com.blogapp18.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto ,long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();

         Comment comment = mapToEntity(commentDto);
         comment.setPost(post);
         Comment savedComment = commentRepository.save(comment);

        CommentDto dto = mapToDto(savedComment);


        return dto;
    }




    Comment mapToEntity(CommentDto dto){
        Comment comment = modelMapper.map(dto, Comment.class);
        return comment;

    }CommentDto mapToDto(Comment comment){
         return modelMapper.map(comment, CommentDto.class);

    }

}
