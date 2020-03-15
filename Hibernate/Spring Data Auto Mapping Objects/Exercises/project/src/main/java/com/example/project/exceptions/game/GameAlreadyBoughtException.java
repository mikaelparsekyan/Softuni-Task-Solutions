package com.example.project.exceptions.game;

public class GameAlreadyBoughtException extends Exception{
    public GameAlreadyBoughtException() {
        super("You already bought this game!");
    }
}
