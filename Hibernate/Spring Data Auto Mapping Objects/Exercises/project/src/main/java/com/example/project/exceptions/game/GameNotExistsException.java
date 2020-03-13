package com.example.project.exceptions.game;

public class GameNotExistsException extends Exception{
    public GameNotExistsException() {
        super("Game with this id not exists!");
    }
}
