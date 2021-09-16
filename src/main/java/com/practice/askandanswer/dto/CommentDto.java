package com.practice.askandanswer.dto;

import com.practice.askandanswer.entity.Comment;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentDto {
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private Long postId;

    @NotNull
    private String username;


    CommentDto(Comment comment){
        id=comment.getId();
        content=comment.getContent();
        postId=comment.getPost().getId();
        username=comment.getUser().getUsername();
    }
}
