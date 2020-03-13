package com.example.project.exceptions.user;

public class UserNotAdminException extends Exception {
    public UserNotAdminException() {
        super("User do not have this permission!");
    }
}
