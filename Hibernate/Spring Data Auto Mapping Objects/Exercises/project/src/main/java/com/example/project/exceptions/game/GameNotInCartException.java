package com.example.project.exceptions.game;

public class GameNotInCartException extends Exception {
    public GameNotInCartException() {
        super("You did not have this product in the cart!");
    }
}
