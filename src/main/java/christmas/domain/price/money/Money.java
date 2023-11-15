package christmas.domain.price.money;

public abstract class Money {
    protected int money;

    protected Money(int money) {
        this.money = money;
    }

    protected static void validate(int money) {
        if (money < 0)
            throw new IllegalArgumentException();
    }

    public int money() {
        return money;
    }
}
