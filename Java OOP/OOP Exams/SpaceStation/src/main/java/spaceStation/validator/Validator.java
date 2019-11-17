package spaceStation.validator;

public class Validator {
    public static void validateName(String name, String exceptionMessage) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateOxygen(double oxygen, String exceptionMessage) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
