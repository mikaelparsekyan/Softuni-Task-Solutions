package com.example.demo.service.impl;

import com.example.demo.data.dao.UserRepository;
import com.example.demo.data.entiites.User;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, Gson gson) {
        this.userRepository = userRepository;
        this.gson = gson;
    }

    @Override
    public void seedUsersToDatabase() {
        String fileText = FileUtil.readFile("src/main/resources/files/users.json");

        List<User> users = gson.fromJson(fileText,
                new TypeToken<List<User>>() {
                }.getType());

        if (users != null) {
            users.forEach(userRepository::saveAndFlush);
        }
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        int usersCount = userRepository.getAllUsersCount();

        long userId = random.nextInt(usersCount) + 1;

        return userRepository.findById(userId);
    }
}
