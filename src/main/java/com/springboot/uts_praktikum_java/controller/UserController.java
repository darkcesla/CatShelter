package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by username
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findById(username).orElse(null);
    }

    
    @PostMapping("/post/login")
    public String login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null) {
            return "Username tidak ditemukan";
        }
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Password salah";
        }
        return "Login berhasil";
    }
    
    
    
    // Create a new user
    @PostMapping("/post")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
//    @PostMapping("/post/login")
//    public String loginUser(@RequestBody User loginUser) {
//        String username = loginUser.getUsername();
//        String password = loginUser.getPassword();
//
//        User user = userRepository.findByUsernameAndPassword(username, password);
//
//        if (user != null) {
//            return "success";
//        } else {
//            return "error"; 
//        }
//    }

    @PutMapping("/put/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User newUser) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    // Delete user
    @DeleteMapping("/delete/{username}")
    public void deleteUser(@PathVariable String username) {
        userRepository.deleteById(username);
    }
}
