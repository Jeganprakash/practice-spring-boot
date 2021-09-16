package com.practice.askandanswer.rest;
import com.practice.askandanswer.dto.PostDto;
import com.practice.askandanswer.entity.Post;
import com.practice.askandanswer.entity.User;
import com.practice.askandanswer.service.PostService;
import com.practice.askandanswer.service.ApplicationUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PostController {

    private final PostService postService;
    private final ApplicationUserService userService;

    @Autowired
    public PostController(PostService postService, ApplicationUserService userService) {
        this.postService = postService;
        this.userService=userService;
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts(){
        List<PostDto> responseList = new ArrayList<PostDto>();
        for(Post post:postService.getAll())
            responseList.add(new PostDto(post));
        return responseList;
    }

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable Long id){
        return new PostDto(postService.getById(id));
    }


    @PostMapping("/posts")
    public PostDto savePost(@RequestBody PostDto postDto){
        Post createdPost = postService.createOrUpdate(convertDtoToEntity(postDto));
        addPostToUser(createdPost);
        return new PostDto(createdPost);
    }

    @PutMapping("/posts/{id}")
    public void UpdatePost(@RequestBody PostDto postDto,@PathVariable Long id, Principal principal){
        Post post = postService.getById(id);
        post.setContent(postDto.getContent());

        //check weather the post is owned by the authenticated user
        if(post.getUser().getUsername().equals(principal.getName())){
            log.debug("Successfully Updated");
            postService.createOrUpdate(post);
        }
        else {
            throw new RuntimeException("You have no permission");
        }

    }

    @DeleteMapping("/posts/{id}")
    public void deleteById(@PathVariable Long id, Principal principal) throws RuntimeException{
        Post post = postService.getById(id);

        //check weather the post is owned by the authenticated user
        if(post.getUser().getUsername().equals(principal.getName())){
            log.debug("Successfully Deleted");
            postService.delete(id);
        }
        else {
            throw new RuntimeException("You have no permission");
        }

    }

    private Post convertDtoToEntity(PostDto postDto){
        User user = userService.getById(postDto.getUsername());
        Post post = new Post();
        post.setId(null);
        post.setUser(user);
        post.setContent(postDto.getContent());
        return post;
    }

    private void addPostToUser(Post post){
        User user=post.getUser();
        user.getPosts().add(post);
    }





}
