package com.practice.askandanswer.service;

import com.practice.askandanswer.dao.UserRepository;
import com.practice.askandanswer.entity.Role;
import com.practice.askandanswer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataJPAUserService implements ApplicationUserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public SpringDataJPAUserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getById(String name) {
        return userRepository.findById(name).get();
    }

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public void delete(String name) {
        userRepository.deleteById(name);
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoletoUser(String username, String role) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return user;
    }
}
