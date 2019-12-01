package viceCity.core.validator;


public class Validator {
    public static void validateName(String name, String message) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(message);
        }
    }

    public static void validateNumber(int points, String message) {
        if (points < 0) {
            throw new IllegalArgumentException(message);
        }
    }

}
