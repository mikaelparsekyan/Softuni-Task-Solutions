package com.example.project.init;

import com.example.project.data.dtos.UserLoginDto;
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
        String command;
        do {
            System.out.println("Enter command: ");
            command = scanner.nextLine();
            String[] commandParts = command.split("\\|");
            parseCommand(commandParts);
        } while (!(command).equals("Stop"));
    }

    private void parseCommand(String[] commandParts) {
        switch (commandParts[0]) {
            case "RegisterUser":
                if (commandParts[2].equals(commandParts[3])) {
                    //register user if passwords match
                    registerUser(commandParts);
                } else {
                    System.err.println("Passwords did not match!");
                }
                break;

            case "LoginUser":
                loginUser(commandParts);
                break;

            case "Logout":
                userService.logoutUser();
                break;

            default:
                System.out.println("Unexpected command.");
                break;
        }
    }

    private void loginUser(String[] commandParts) {
        UserLoginDto user = new UserLoginDto(
                commandParts[1],
                commandParts[2]
        );
        userService.loginUser(user);
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
