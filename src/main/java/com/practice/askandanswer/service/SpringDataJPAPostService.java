package com.practice.askandanswer.service;

import com.practice.askandanswer.dao.PostRepository;
import com.practice.askandanswer.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataJPAPostService implements PostService{


    private PostRepository postRepository;

    @Autowired
    public SpringDataJPAPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post createOrUpdate(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
