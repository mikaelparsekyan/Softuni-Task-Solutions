package com.spring.project.spring.user_system.services.impls;

import com.spring.project.spring.user_system.entities.User;
import com.spring.project.spring.user_system.repositories.UserRepository;
import com.spring.project.spring.user_system.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void removeInactiveUsers(LocalDate date) {
        userRepository
                .findAllByLastTimeLoggedInBefore(date)
                .forEach(user -> userRepository.delete(user));


        System.out.println();
    }

    @Override
    public void getAllByEmailProvider(String emailProvider) {
        for (User user : userRepository.getAllByEmailEndsWith(emailProvider)) {
            System.out.printf("%s %s %n", user.getFirstName(), user.getLastName());
        }

    }


}
