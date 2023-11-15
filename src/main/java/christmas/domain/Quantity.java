package christmas.domain;

import christmas.validator.OrderValidator;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(String quantity) {
        OrderValidator.validateQuantityNumber(quantity);
        return new Quantity(Integer.parseInt(quantity));
    }

    public int getQuantity() {
        return quantity;
    }
}
