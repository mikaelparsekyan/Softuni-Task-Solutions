package com.example.project.exceptions.user;

public class LogoutException extends Exception {
    public LogoutException() {
        super("Cannot log out. No user was logged in.");
    }
}
