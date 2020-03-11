package com.example.project.services.impls;

import com.example.project.data.dtos.UserRegisterDto;
import com.example.project.data.entities.User;
import com.example.project.data.enums.UserRole;
import com.example.project.data.repositories.UserRepository;
import com.example.project.services.UserService;
import com.example.project.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean registerUser(UserRegisterDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        if (userRepository.findAll().isEmpty()) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.USER);
        }
        if (validationUtil.isValid(user)) {
            userRepository.saveAndFlush(user);
            System.out.printf("Successfully registration of user: %s%n",
                    user.getFullName());
            return true;
        }

        validationUtil
                .getViolations(user)
                .forEach(System.out::println);
        return false;
    }
}
