package com.example.project.services.impls;

import com.example.project.data.dtos.UserLoginDto;
import com.example.project.data.dtos.UserRegisterDto;
import com.example.project.data.entities.User;
import com.example.project.data.enums.UserRole;
import com.example.project.data.repositories.UserRepository;
import com.example.project.exceptions.LogoutException;
import com.example.project.exceptions.UserLoginException;
import com.example.project.exceptions.UserNotExistException;
import com.example.project.services.UserService;
import com.example.project.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private User loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        if (userRepository.findAll().isEmpty()) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.USER);
        }
        if (validationUtil.isValid(user)) {
            try {
                userRepository.saveAndFlush(user);
                System.out.printf("Successfully registration of user: %s%n",
                        user.getFullName());
            } catch (DataIntegrityViolationException e) {
                System.err.println("This user already exists!");

            }
        } else {

            String errorMessage = new ArrayList<>(validationUtil
                    .getViolations(user))
                    .get(0)
                    .getMessage();

            System.out.println(errorMessage);
        }
    }

    @Override
    public void loginUser(UserLoginDto userDto) {
        loggedUser = userRepository.findUserByEmail(userDto.getEmail());

        try {
            if (loggedUser == null) {
                throw new UserNotExistException();
            } else if (!loggedUser.getPassword().equals(userDto.getPassword())) {
                throw new UserLoginException();
            }
            System.out.printf("Successfully logged in %s%n", loggedUser.getFullName());
        } catch (UserLoginException | UserNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void logoutUser() {
        try {
            if (this.loggedUser == null) {
                throw new LogoutException();
            }
            System.out.printf("User %s successfully logged out%n",
                    loggedUser.getFullName());
            this.loggedUser = null;
        } catch (LogoutException e) {
            System.out.println(e.getMessage());
        }
    }
}
