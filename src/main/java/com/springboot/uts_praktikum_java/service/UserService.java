package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String username, User newUser) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        } else {
            return null; // User not found
        }
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}
