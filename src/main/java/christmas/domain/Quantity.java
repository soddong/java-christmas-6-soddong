package christmas.domain;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(String quantity) {
        validate(quantity);
        return new Quantity(Integer.parseInt(quantity));
    }

    private static void validate(String quantity) {
        if (quantity == null || quantity.isBlank())
            throw new IllegalArgumentException();

        int value = Integer.parseInt(quantity);
        if (value < 1)
            throw new IllegalArgumentException();
    }

    public int getQuantity() {
        return quantity;
    }
}
