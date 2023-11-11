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
        // 빈 경우
        if (quantity.isBlank())
            throw new IllegalArgumentException();

        // 숫자가 아닌 경우
        int tmp;
        try {
            tmp = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        // 1~20 사이 range 체크
        if (tmp < 1 || tmp > 20)
            throw new IllegalArgumentException();
    }

    public Quantity add(Quantity other) {
        return new Quantity(this.quantity + other.quantity);
    }

    public boolean isOver(final int value) {
        return this.quantity > value;
    }
}
