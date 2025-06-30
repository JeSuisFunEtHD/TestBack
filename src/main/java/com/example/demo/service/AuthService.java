package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) return false;
        userRepository.save(user);
        return true;
    }

    public boolean authenticate(User user) {
        User existing = userRepository.findByUsername(user.getUsername());
        return existing != null && existing.getPassword().equals(user.getPassword());
    }
}