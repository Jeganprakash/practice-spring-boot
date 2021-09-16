package com.practice.askandanswer.service;

import com.practice.askandanswer.entity.Role;
import com.practice.askandanswer.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ApplicationUserService {
        public List<User> getUsers();
        public User getById(String name);
        public User save(User user);
        public void delete(String name);
        public Role saveRole(Role role);
        public void addRoletoUser(String username,String role);
    }


