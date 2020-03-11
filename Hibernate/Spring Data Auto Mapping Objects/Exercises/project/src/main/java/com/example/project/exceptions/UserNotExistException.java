package com.example.project.exceptions;

public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("User not exists");
    }
}
