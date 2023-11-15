package christmas.validator;

import christmas.view.ExceptionMessage;

public class CommonValidator {
    public static void validateNotEmpty(String input, String item) {
        if (input.isEmpty())
            throw ExceptionMessage.INVALID_VALUE.create(item);
    }

    public static void validateNumber(String input, String item) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ExceptionMessage.INVALID_VALUE.create(item);
        }
    }
}
