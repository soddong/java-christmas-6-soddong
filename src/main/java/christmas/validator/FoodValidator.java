package christmas.validator;

import static christmas.validator.CommonValidator.validateNotEmpty;
import static christmas.validator.CommonValidator.validateNumber;

import christmas.domain.food.Menu;

public class FoodValidator {
    private final static String ORDER = "주문";

    public static void validateFoodName(String name) {
        validateExistsMenu(name);
    }

    private static void validateExistsMenu(final String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }

    public static void validateQuantityNumber(String quantity) {
        validateNotEmpty(quantity, ORDER);
        validateNumber(quantity, ORDER);
        validateQuantity(quantity);
    }
    
    private static void validateQuantity(final String quantity) {
        int val = Integer.parseInt(quantity);
        if (val < 1) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }
}
