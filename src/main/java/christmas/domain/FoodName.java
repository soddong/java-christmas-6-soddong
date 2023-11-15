package christmas.domain;

import christmas.validator.OrderValidator;

public class FoodName {
    private String name;

    private FoodName(String name) {
        this.name = name;
    }

    public static FoodName from(final String name) {
        OrderValidator.validateFoodName(name);
        return new FoodName(name);
    }

    public String getName() {
        return name;
    }
}
