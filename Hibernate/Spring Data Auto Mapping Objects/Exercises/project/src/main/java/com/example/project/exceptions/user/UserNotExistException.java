package com.example.project.exceptions.user;

public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("User not exists");
    }
}
