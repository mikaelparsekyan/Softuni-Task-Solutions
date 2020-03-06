package com.spring.project.spring.user_system.init;

import com.spring.project.spring.user_system.entities.User;
import com.spring.project.spring.user_system.repositories.UserRepository;
import com.spring.project.spring.user_system.services.UserService;
import com.spring.project.spring.user_system.validator.PasswordValidator;
import com.spring.project.spring.user_system.validator.annotations.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class Runner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = createUser();

        userService.save(user);
        //userService.removeInactiveUsers(LocalDate.of(1555,1,3));

        userService.getAllByEmailProvider("@abv.bg");


    }

    private User createUser() {
        User user = new User();
        user.setFirstName("George");
        user.setLastName("Smith");
        user.setAge(34);
        user.setLastTimeLoggedIn(LocalDate.of(1555,4,3));
        user.setRegisteredOn(LocalDate.of(1233,2,2));
        user.setEmail("f");
        user.setUsername("george555");
        user.setPassword("a");//
        return user;
    }
}
