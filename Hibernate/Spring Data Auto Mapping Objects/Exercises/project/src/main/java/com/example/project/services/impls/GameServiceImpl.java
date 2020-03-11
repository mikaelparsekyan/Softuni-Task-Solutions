package com.example.project.services.impls;

import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import com.example.project.data.enums.UserRole;
import com.example.project.data.repositories.GameRepository;
import com.example.project.data.repositories.UserRepository;
import com.example.project.exceptions.UserNotAdminException;
import com.example.project.exceptions.UserNotLoggedException;
import com.example.project.services.GameService;
import com.example.project.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
            if (validationUtil.isValid(game)) {
                if (loggedUser.getRole() == UserRole.ADMIN) {
                    gameRepository.saveAndFlush(game);
                    System.out.printf("Added %s%n", game.getTitle());
                } else {
                    throw new UserNotAdminException();
                }
            }
        } catch (UserNotAdminException | UserNotLoggedException e) {
            System.out.println(e.getMessage());
        }
    }
}
