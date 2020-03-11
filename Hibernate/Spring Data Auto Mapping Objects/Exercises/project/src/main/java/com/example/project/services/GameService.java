package com.example.project.services;

import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    void addGame(Game game, User loggedUser);
}
