package christmas.domain.food;

import christmas.validator.FoodValidator;

public class FoodName {
    private final String name;

    private FoodName(String name) {
        this.name = name;
    }

    public static FoodName from(final String name) {
        FoodValidator.validateFoodName(name);
        return new FoodName(name);
    }

    public String getName() {
        return name;
    }
}
