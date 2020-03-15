package com.example.project.services.impls;

import com.example.project.data.dtos.game.DeleteGameDto;
import com.example.project.data.dtos.game.EditGameDto;
import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import com.example.project.data.enums.UserRole;
import com.example.project.data.repositories.GameRepository;
import com.example.project.data.repositories.UserRepository;
import com.example.project.exceptions.game.GameNotExistsException;
import com.example.project.exceptions.user.UserNotAdminException;
import com.example.project.exceptions.user.UserNotLoggedException;
import com.example.project.services.GameService;
import com.example.project.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(Game game, User loggedUser) {
        try {
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }
            if(game == null){
                throw new GameNotExistsException();
            }
            if (validationUtil.isValid(game)) {
                if (loggedUser.getRole() == UserRole.ADMIN) {
                    gameRepository.saveAndFlush(game);
                    System.out.printf("Added %s%n", game.getTitle());
                } else {
                    throw new UserNotAdminException();
                }
            }
        } catch (UserNotAdminException | UserNotLoggedException |
                GameNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editGame(String[] lineInput, User loggedUser) {
        try {
            long gameId = Long.parseLong(lineInput[1]);
            if (gameId <= 0) {
                throw new IllegalArgumentException();
            }
            Game game = gameRepository.findById(gameId);
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }
            if (game == null) {
                throw new GameNotExistsException();
            }
            if (loggedUser.getRole() == UserRole.USER) {
                throw new UserNotAdminException();
            }

            List<String> values = Arrays.stream(lineInput)
                    .skip(2)
                    .collect(Collectors.toList());

            for (String line : values) {
                String[] elements = line.split("=");
                String valueName = elements[0];
                String value = elements[1];

                addValueToGame(valueName, value, game);
            }
            gameRepository.saveAndFlush(game);
            System.out.printf("Edited %s%n", game.getTitle());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid id!");
        } catch (GameNotExistsException | UserNotAdminException
                | UserNotLoggedException e) {
            System.out.println(e.getMessage());
        } catch (ConstraintViolationException e) {
            System.out.println(new ArrayList<>(e.getConstraintViolations())
                    .get(0)
                    .getMessage());
        }
    }

    private void addValueToGame(String valueName, String value, Game game) {
        try {
            Field[] fields = Game.class.getDeclaredFields();
            Method[] methods = Game.class.getDeclaredMethods();

            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(valueName)) {
                    for (Method method : methods) {
                        method.setAccessible(true);
                        if (method.getName()
                                .equalsIgnoreCase("set".concat(field.getName()))) {
                            Class<?> inputType = method.getParameterTypes()[0];
                            String paramTypeName = inputType.getSimpleName();
                            if (paramTypeName.equals("String")) {
                                method.invoke(game, value);
                            } else if (paramTypeName.equals("double")) {
                                method.invoke(game, Double.parseDouble(value));
                            } else if (paramTypeName.equals("int")) {
                                method.invoke(game, Integer.parseInt(value));
                            } else if (paramTypeName.equals("BigDecimal")) {
                                method.invoke(game, new BigDecimal(value));
                            } else if (paramTypeName.equals("LocalDate")) {
                                method.invoke(game, LocalDate.parse(value,
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                            } else {
                                System.out.printf("No value with name %s exists %n", value);
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type of argument!");
        } catch (DateTimeParseException e) {
            System.out.println("Wrong date format!");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGame(DeleteGameDto deleteGameDto, User loggedUser) {
        Game gameToDelete = gameRepository.findById(deleteGameDto.getId());
        try {
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }

            if (gameToDelete == null) {
                throw new GameNotExistsException();
            }
            if (loggedUser.getRole() != UserRole.ADMIN) {
                throw new UserNotAdminException();
            }
            gameRepository.delete(gameToDelete);
            System.out.printf("Deleted %s%n", gameToDelete.getTitle());
        } catch (GameNotExistsException | UserNotAdminException |
                UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printAllGames() {
        List<Game> games = gameRepository.findAll();
        if (games == null) {
            System.out.println("There aren't any games!");
            return;
        }
        for (Game game : games) {
            System.out.printf("%s %.2f%n", game.getTitle(), game.getPrice().floatValue());
        }
    }

    @Override
    public void printGameDetailByTitle(String title) {
        Game game = gameRepository.findGameByTitle(title);
        try {

            if (game == null) {
                throw new GameNotExistsException();
            }
            System.out.println(game.toString());

        } catch (GameNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printAllOwnedGames(User loggedUser) {
        List<Game> games = gameRepository.getGamesByUsers(loggedUser);
        try {
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }
            if (games == null) {
                throw new GameNotExistsException();
            }

            games.forEach(game -> System.out.println(game.getTitle()));
        } catch (GameNotExistsException | UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }
}
