package com.practice.askandanswer.dao;

import com.practice.askandanswer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //implementation are provided by spring data jpa
}