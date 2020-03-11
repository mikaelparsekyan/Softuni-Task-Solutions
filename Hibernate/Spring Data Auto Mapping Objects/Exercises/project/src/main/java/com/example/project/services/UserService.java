package com.example.project.services;

import com.example.project.data.dtos.user.UserLoginDto;
import com.example.project.data.dtos.user.UserRegisterDto;
import com.example.project.data.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserRegisterDto userDto);

    void loginUser(UserLoginDto userDto);

    void logoutUser();

    User getLoggedUser();
}
