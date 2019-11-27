package tests.core.validator;

import tests.core.messages.ExceptionMessages;

public class Validator {
    private static String[] operators = {"+", "-", "/", "*"};

    public static void validateOperator(String operator) {
        boolean isValidOperator = false;
        for (String o : operators) {
            if (o.equals(operator)) {
                isValidOperator = true;
                break;
            }
        }
        if (!isValidOperator) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_OPERATION);
        }
    }

    public static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER);
        }
    }
}
