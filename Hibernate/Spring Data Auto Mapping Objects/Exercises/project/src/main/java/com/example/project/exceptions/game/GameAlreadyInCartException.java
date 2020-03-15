package com.example.project.exceptions.game;

public class GameAlreadyInCartException extends Exception {
    public GameAlreadyInCartException() {
        super("You already added this in the shopping cart!");
    }
}
