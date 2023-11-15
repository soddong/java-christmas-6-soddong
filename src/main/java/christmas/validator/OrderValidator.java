package christmas.validator;

import christmas.domain.Menu;
import christmas.view.ExceptionMessage;

import static christmas.validator.CommonValidator.validateNotEmpty;
import static christmas.validator.CommonValidator.validateNumber;

public class OrderValidator {
    private final static String ORDER = "주문";
    public static void validateFoodName(String name) {
        validateExistsMenu(name);
    }

    public static void validateQuantityNumber(String quantity) {
        validateNotEmpty(quantity, ORDER);
        validateNumber(quantity, ORDER);
        validateQuantity(quantity);
    }

    private static void validateQuantity(String quantity) {
        int val = Integer.parseInt(quantity);
        if (val < 1)
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
    }

    private static void validateExistsMenu(String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalStateException e) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }
}
