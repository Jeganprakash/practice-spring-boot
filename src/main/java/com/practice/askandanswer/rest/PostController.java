package com.practice.askandanswer.rest;
import com.practice.askandanswer.dto.PostDto;
import com.practice.askandanswer.entity.Post;
import com.practice.askandanswer.entity.User;
import com.practice.askandanswer.service.PostService;
import com.practice.askandanswer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    private UserService userService;

    @Autowired
    public PostController(PostService postService,UserService userService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts(){
        List<PostDto> responseList = new ArrayList<PostDto>();
        for(Post post:postService.getAll())
            responseList.add(convertEntityToDto(post));
        return responseList;
    }

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable Integer id){
        return convertEntityToDto(postService.getById(id));
    }


    @PostMapping("/posts")
    public PostDto savePost(@RequestBody PostDto postDto){
        Post createdPost = postService.createOrUpdate(convertDtoToEntity(postDto));
        return convertEntityToDto(createdPost);
    }

    @PutMapping("/posts")
    public void UpdatePost(@RequestBody PostDto postDto){
        postService.createOrUpdate(convertDtoToEntity(postDto));
    }

    @DeleteMapping("/posts/{id}")
    public void deleteById(@PathVariable Integer id){
        postService.delete(id);
    }


    private PostDto convertEntityToDto(Post post){
        return new PostDto(post.getId(),post.getContent(),post.getUser().getUsername());
    }

    private Post convertDtoToEntity(PostDto postDto){
        User user = userService.getById(postDto.getUsername());
        return new Post(0,postDto.getContent(),user);
    }





}
