package com.example.project.services;

import com.example.project.data.dtos.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean registerUser(UserRegisterDto userDto);
}
