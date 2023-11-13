package christmas.domain;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    public Money add(Money other) {
        return new Money(this.money + other.money);
    }

    private static void validate(int money) {
        if (money < 0)
            throw new IllegalArgumentException();
    }


}
