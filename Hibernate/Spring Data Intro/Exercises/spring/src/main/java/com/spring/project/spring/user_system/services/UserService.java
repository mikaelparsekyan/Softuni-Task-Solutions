package com.spring.project.spring.user_system.services;

import com.spring.project.spring.user_system.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("UserService")
public interface UserService {
    void save(User user);

    void removeInactiveUsers(LocalDate date);

    void getAllByEmailProvider(String emailProvider);
}
