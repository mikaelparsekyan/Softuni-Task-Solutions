package com.example.demo.service.api;

import com.example.demo.data.entiites.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface UserService {
    void seedUsersToDatabase();

    User getRandomUser();

    Set<User> getRandomUsers();

    List<User> getAllUsers();
}
