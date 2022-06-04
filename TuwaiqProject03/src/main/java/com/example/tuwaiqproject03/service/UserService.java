package com.example.tuwaiqproject03.service;

import com.example.tuwaiqproject03.model.User;
import com.example.tuwaiqproject03.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "user add !";
    }
}
