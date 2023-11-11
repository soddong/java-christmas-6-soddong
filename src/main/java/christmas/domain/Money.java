package christmas.domain;

public class Money {
    private int meony;

    public Money(int meony) {
        this.meony = meony;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    private static void validate(int money) {
        if (money < 0)
            throw new IllegalArgumentException();
    }
}
