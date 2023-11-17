package christmas.domain.food;

import christmas.validator.OrderValidator;

public class FoodName {
    private String name;

    private FoodName(String name) {
        this.name = name;
    }

    public static FoodName from(String name) {
        OrderValidator.validateFoodName(name);
        return new FoodName(name);
    }

    public String getName() {
        return name;
    }
}
