package com.example.project.services;

import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import org.springframework.stereotype.Service;


@Service
public interface GameService {
    void addGame(Game game, User loggedUser);

    void editGame(String[] lineInput, User loggedUser);

    void deleteGame(long id, User loggedUser);

    void printAllGames();

    void printGameDetailByTitle(String title);

    void printAllOwnedGames(User loggedUser);
}
