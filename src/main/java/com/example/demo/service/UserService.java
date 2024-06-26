package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable Long id, User user) {
        User existUser = userRepository.findById(id).orElse(null);
        if(existUser == null) return null;
        existUser.setEmail(user.getEmail());
        existUser.setPassword(user.getPassword());
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setAddress(user.getAddress());
        return userRepository.save(existUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
