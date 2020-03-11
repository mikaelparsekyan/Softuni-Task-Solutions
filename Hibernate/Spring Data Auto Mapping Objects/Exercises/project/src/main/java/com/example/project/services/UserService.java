package com.example.project.services;

import com.example.project.data.dtos.UserLoginDto;
import com.example.project.data.dtos.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserRegisterDto userDto);

    void loginUser(UserLoginDto userDto);

    void logoutUser();
}
