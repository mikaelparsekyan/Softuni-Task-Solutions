package com.example.project.exceptions.game;

public class GameNotExistsException extends Exception{
    public GameNotExistsException() {
        super("Game not exists!");
    }
}
