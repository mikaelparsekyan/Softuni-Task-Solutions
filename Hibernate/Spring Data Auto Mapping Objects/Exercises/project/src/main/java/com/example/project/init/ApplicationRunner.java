package com.example.project.init;

import com.example.project.data.dtos.game.EditGameDto;
import com.example.project.data.dtos.user.UserLoginDto;
import com.example.project.data.dtos.user.UserRegisterDto;
import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import com.example.project.services.GameService;
import com.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    private final Scanner scanner;

    @Autowired
    public ApplicationRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
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

            case "AddGame":
                addGame(commandParts);
                break;

            case "EditGame":
                gameService.editGame(commandParts, userService.getLoggedUser());
                break;

            case "DeleteGame":
                deleteGame(commandParts);
                break;

            case "AllGames":
                gameService.printAllGames();
                break;

            case "DetailGame":
                gameService.printGameDetailByTitle(commandParts[1]);
                break;

            case "OwnedGames":
                gameService.printAllOwnedGames(userService.getLoggedUser());
                break;

            case "AddItem":
                userService.addItemToShoppingCart(commandParts[1]);
                break;

            case "RemoveItem":
                userService.removeItemFromShoppingCart(commandParts[1]);
                break;

            case "BuyItem":
                userService.buyAllItemsInTheShoppingCart();
                break;

            case "Stop":
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected command.");
                break;
        }
    }

    private void deleteGame(String[] commandParts) {
        try {
            long id = Long.parseLong(commandParts[1]);
            if (id <= 0) {
                throw new IllegalArgumentException();
            }
            gameService.deleteGame(id, userService.getLoggedUser());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid type of id!");
        }
    }

    private void addGame(String[] commandParts) {
        User loggedUser = userService.getLoggedUser();
        Game game = new Game(
                commandParts[1],
                commandParts[4],
                commandParts[5],
                new BigDecimal(commandParts[2]),
                Double.parseDouble(commandParts[3]),
                commandParts[6],
                LocalDate.parse(commandParts[7],
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );
        gameService.addGame(game, loggedUser);
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
