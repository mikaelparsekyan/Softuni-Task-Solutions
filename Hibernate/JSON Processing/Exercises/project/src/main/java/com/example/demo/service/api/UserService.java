package com.example.demo.service.api;

import com.example.demo.data.entiites.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    void seedUsersToDatabase();

    User getRandomUser();

    void exportAllUsersWithSuccessfullySoldProducts();

    void exportAllUsersAndProducts();
}
