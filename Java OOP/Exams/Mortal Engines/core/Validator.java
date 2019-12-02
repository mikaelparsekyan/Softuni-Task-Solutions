package core;

import entities.interfaces.Pilot;

public class Validator {
    public static void validateName(String name, String exceptionMessage) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validatePilot(Pilot pilot, String exceptionMessage) {
        if (pilot == null) {
            throw new NullPointerException(exceptionMessage);
        }
    }
}
