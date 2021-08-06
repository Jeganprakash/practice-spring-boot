package com.practice.askandanswer.service;

import com.practice.askandanswer.dao.UserRepository;
import com.practice.askandanswer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataJPAUserService implements UserService{

    private UserRepository UserRepository;

    @Autowired
    public SpringDataJPAUserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public List<User> getAll() {
        return UserRepository.findAll();
    }

    @Override
    public User getById(String name) {
        return UserRepository.findById(name).get();
    }

    @Override
    public User createOrUpdate(User User) {
        return UserRepository.save(User);
    }

    @Override
    public void delete(String name) {
        UserRepository.deleteById(name);
    }
}
