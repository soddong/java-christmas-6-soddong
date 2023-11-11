package christmas.domain;

public record Money(int money) {

    public static Money from(int money) {
        return new Money(money);
    }
}
