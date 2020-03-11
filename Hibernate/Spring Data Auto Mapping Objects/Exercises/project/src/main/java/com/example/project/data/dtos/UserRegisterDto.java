package com.example.project.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDto {
    private String email;

    private String password;

    private String fullName;
}
