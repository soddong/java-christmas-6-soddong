package christmas.domain.food;

import christmas.validator.FoodValidator;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(String quantity) {
        FoodValidator.validateQuantityNumber(quantity);
        return new Quantity(Integer.parseInt(quantity));
    }

    public int getQuantity() {
        return quantity;
    }
}
