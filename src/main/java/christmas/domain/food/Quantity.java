package christmas.domain.food;

import christmas.validator.FoodValidator;

public class Quantity {
    private final int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(final String quantity) {
        FoodValidator.validateQuantityNumber(quantity);
        return new Quantity(Integer.parseInt(quantity));
    }

    public int getQuantity() {
        return quantity;
    }
}
