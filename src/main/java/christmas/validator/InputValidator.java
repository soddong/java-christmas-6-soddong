package christmas.validator;

import christmas.view.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static christmas.validator.CommonValidator.validateNotEmpty;
import static christmas.validator.CommonValidator.validateNumber;
import static christmas.validator.ValidatorConstant.FULL;
import static christmas.validator.ValidatorConstant.PART;

public class InputValidator {
    private final static String DATE = "날짜";
    private final static String ORDER = "주문";

    public static void validateInputDateNumber(String input) {
        validateNotEmpty(input, DATE);
        validateNumber(input, DATE);
        validateDate(input);
    }

    public static void validateInputOrderString(String inputs) {
        validateNotEmpty(inputs, ORDER);
        List<String> items = Arrays.asList(inputs.split(","));
        for (String item : items) {
            validateOrder(item.split("-").length);
        }
    }

    private static void validateDate(String input) {
        int val = Integer.parseInt(input);
        if (val < 1 || val > 31)
            throw ExceptionMessage.INVALID_VALUE.create(DATE);
    }

    private static void validateOrder(int size) {
        if (size != 2)
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
    }
}
