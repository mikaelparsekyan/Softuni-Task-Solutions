package com.example.project.init;

import com.example.project.data.dtos.UserRegisterDto;
import com.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final UserService userService;
    private final Scanner scanner;

    @Autowired
    public ApplicationRunner(UserService userService) {
        this.userService = userService;
        scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        String command = scanner.nextLine();
        while (!"Logout".equals(command)) {
            String[] commandParts = command.split("\\|");

            parseCommand(commandParts);

            command = scanner.nextLine();
        }
    }

    private void parseCommand(String[] commandParts) {
        switch (commandParts[0]) {
            case "RegisterUser":
                registerUser(commandParts);
                break;

            case "LoginUser":

                break;

            case "Logout":

                break;
        }
    }

    private void registerUser(String[] commandParts) {
        UserRegisterDto user = new UserRegisterDto(
                commandParts[1],
                commandParts[2],
                commandParts[4]
        );
        userService.registerUser(user);
    }
}
