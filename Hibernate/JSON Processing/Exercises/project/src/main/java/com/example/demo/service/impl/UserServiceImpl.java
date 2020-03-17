package com.example.demo.service.impl;

import com.example.demo.data.dao.UserRepository;
import com.example.demo.data.entiites.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private Gson gson;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void seedUsersToDatabase() {
        File file = new File("src/main/resources/files/users.json");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder fileBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileBuilder.append(line);
            }
            List<User> users = gson.fromJson(fileBuilder.toString(), new TypeToken<List<User>>() {
            }.getType());

            users.forEach(userRepository::saveAndFlush);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
