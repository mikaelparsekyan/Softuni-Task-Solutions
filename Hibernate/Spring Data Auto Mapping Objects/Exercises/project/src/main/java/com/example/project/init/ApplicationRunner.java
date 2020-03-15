package com.example.project.init;

import com.example.project.data.dtos.game.AddGameToShoppingCartDto;
import com.example.project.data.dtos.game.DeleteGameDto;
import com.example.project.data.dtos.game.EditGameDto;
import com.example.project.data.dtos.game.RemoveGameFromShoppingCartDto;
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
        try {
            switch (commandParts[0].toLowerCase()) {
                case "registeruser":
                    if (commandParts[2].equals(commandParts[3])) {
                        //register user if passwords match
                        registerUser(commandParts);
                    } else {
                        System.err.println("Passwords did not match!");
                    }
                    break;

                case "loginuser":
                    loginUser(commandParts);
                    break;

                case "logout":
                    userService.logoutUser();
                    break;

                case "addgame":
                    addGame(commandParts);
                    break;

                case "editgame":
                    gameService.editGame(commandParts, userService.getLoggedUser());
                    break;

                case "deletegame":
                    deleteGame(commandParts);
                    break;

                case "allgames":
                    gameService.printAllGames();
                    break;

                case "detailgame":
                    gameService.printGameDetailByTitle(commandParts[1]);
                    break;

                case "ownedgames":
                    gameService.printAllOwnedGames(userService.getLoggedUser());
                    break;

                case "additem":
                    addGameToShoppingCart(commandParts);
                    break;

                case "removeitem":
                    removeGameFromShoppingCart(commandParts);
                    break;

                case "buyitem":
                    userService.buyAllGamesInTheShoppingCart();
                    break;

                case "stop":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unexpected command.");
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid number of arguments for the current command!");
        }
    }

    private void removeGameFromShoppingCart(String[] commandParts) throws ArrayIndexOutOfBoundsException{
        RemoveGameFromShoppingCartDto gameDto =
                new RemoveGameFromShoppingCartDto(commandParts[1]);

        userService.removeGameFromShoppingCart(gameDto);
    }

    private void addGameToShoppingCart(String[] commandParts) throws ArrayIndexOutOfBoundsException{
        AddGameToShoppingCartDto gameDto =
                new AddGameToShoppingCartDto(commandParts[1]);

        userService.addGameToShoppingCart(gameDto);
    }

    private void deleteGame(String[] commandParts) throws ArrayIndexOutOfBoundsException{
        try {
            long id = Long.parseLong(commandParts[1]);
            if (id <= 0) {
                throw new IllegalArgumentException();
            }
            DeleteGameDto deleteGameDto = new DeleteGameDto(id);
            gameService.deleteGame(deleteGameDto, userService.getLoggedUser());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid type of id!");
        }
    }

    private void addGame(String[] commandParts) throws ArrayIndexOutOfBoundsException{
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

    private void loginUser(String[] commandParts) throws ArrayIndexOutOfBoundsException{
        UserLoginDto user = new UserLoginDto(
                commandParts[1],
                commandParts[2]
        );
        userService.loginUser(user);
    }

    private void registerUser(String[] commandParts) throws ArrayIndexOutOfBoundsException{
        UserRegisterDto user = new UserRegisterDto(
                commandParts[1],
                commandParts[2],
                commandParts[4]
        );
        userService.registerUser(user);
    }
}
