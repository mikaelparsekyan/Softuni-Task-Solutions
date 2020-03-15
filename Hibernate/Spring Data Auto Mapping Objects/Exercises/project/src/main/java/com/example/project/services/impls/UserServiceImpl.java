package com.example.project.services.impls;

import com.example.project.data.dtos.game.AddGameToShoppingCartDto;
import com.example.project.data.dtos.game.RemoveGameFromShoppingCartDto;
import com.example.project.data.dtos.user.UserLoginDto;
import com.example.project.data.dtos.user.UserRegisterDto;
import com.example.project.data.entities.Game;
import com.example.project.data.entities.Order;
import com.example.project.data.entities.User;
import com.example.project.data.enums.UserRole;
import com.example.project.data.repositories.GameRepository;
import com.example.project.data.repositories.OrderRepository;
import com.example.project.data.repositories.UserRepository;
import com.example.project.exceptions.game.GameAlreadyBoughtException;
import com.example.project.exceptions.game.GameAlreadyInCartException;
import com.example.project.exceptions.game.GameNotExistsException;
import com.example.project.exceptions.game.GameNotInCartException;
import com.example.project.exceptions.user.*;
import com.example.project.services.UserService;
import com.example.project.validator.ValidationUtil;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Getter
    @Setter
    private User loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository, OrderRepository orderRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;

        this.loggedUser = null;
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
        User userToLogin = userRepository.findUserByEmail(userDto.getEmail());
        try {
            if (this.getLoggedUser() != null) {
                throw new UnsupportedLoginOperation();
            }
            if (userToLogin == null) {
                throw new UserNotExistException();
            } else if (!userToLogin.getPassword().equals(userDto.getPassword())) {
                throw new UserLoginException();
            }
            this.setLoggedUser(userToLogin);
            System.out.printf("Successfully logged in %s%n", getLoggedUser().getFullName());
        } catch (UserLoginException | UserNotExistException |
                UnsupportedLoginOperation e) {
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

    @Override
    public void addGameToShoppingCart(AddGameToShoppingCartDto addGameDto) {
        try {
            Game game = gameRepository.findGameByTitle(addGameDto.getTitle());
            User loggedUser = getLoggedUser();

            List<Game> loggedUserGames = gameRepository.getGamesByUsers(loggedUser);

            System.out.println();
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }
            if (game == null) {
                throw new GameNotExistsException();
            }
            if (loggedUserGames.contains(game)) {
                throw new GameAlreadyBoughtException();
            }
            if (loggedUser.getShoppingCart().contains(game)) {
                throw new GameAlreadyInCartException();
            }
            loggedUser.getShoppingCart().add(game);
            System.out.printf("%s added to cart. %n", game.getTitle());
        } catch (GameNotExistsException | GameAlreadyBoughtException |
                GameAlreadyInCartException | UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeGameFromShoppingCart(RemoveGameFromShoppingCartDto removeGameDto) {
        try {
            Game game = gameRepository.findGameByTitle(removeGameDto.getTitle());
            User loggedUser = getLoggedUser();

            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }

            if (game == null) {
                throw new GameNotExistsException();
            }

            if (!loggedUser.getShoppingCart().contains(game)) {
                throw new GameNotInCartException();
            }

            loggedUser.getShoppingCart().remove(game);
            System.out.printf("%s removed from cart. %n", game.getTitle());
        } catch (GameNotExistsException | GameNotInCartException |
                UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buyAllGamesInTheShoppingCart() {
        User loggedUser = getLoggedUser();

        try {
            if (loggedUser == null) {
                throw new UserNotLoggedException();
            }
            List<Game> shoppingCart = loggedUser.getShoppingCart();

            if (shoppingCart.isEmpty()) {
                throw new EmptyShoppingCartException();
            }
            Order order = new Order();
            order.setBuyer(loggedUser);
            order.setGames(new HashSet<>(shoppingCart));

            loggedUser.getGames().addAll(shoppingCart);
            orderRepository.saveAndFlush(order);
            userRepository.saveAndFlush(loggedUser);

            System.out.println("Successfully bought games:");
            for (Game game : shoppingCart) {
                System.out.printf(" -%s%n", game.getTitle());
            }
            loggedUser.getShoppingCart().clear();
        } catch (EmptyShoppingCartException | UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }
}
