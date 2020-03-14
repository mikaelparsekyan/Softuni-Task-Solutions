package com.example.project.data.repositories;

import com.example.project.data.entities.Game;
import com.example.project.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findById(long id);

    List<Game> findAll();

    Game findGameByTitle(String title);

    List<Game> getGamesByUsers(User loggedUser);
}
