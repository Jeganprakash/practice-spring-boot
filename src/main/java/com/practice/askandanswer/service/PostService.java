package com.practice.askandanswer.service;

import com.practice.askandanswer.entity.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAll();
    public Post getById(Integer id);
    public Post createOrUpdate(Post post);
    public void delete(int id);
}
