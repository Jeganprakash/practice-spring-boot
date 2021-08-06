package com.practice.askandanswer.service;

import com.practice.askandanswer.entity.User;

import java.util.List;

public interface UserService {
        public List<User> getAll();
        public User getById(String name);
        public User createOrUpdate(User user);
        public void delete(String name);
    }


