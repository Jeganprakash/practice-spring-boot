package com.practice.askandanswer.dto;


import com.practice.askandanswer.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PostDto{

    private Long id;

    @NotNull
    private String content;

    @NotNull
    private String username;

    public PostDto(Post post){
        id=post.getId();
        content=post.getContent();
        username=post.getUser().getUsername();
    }
}