package christmas.domain.price.money;

public class KoreaMoney extends Money {
    public KoreaMoney(int money) {
        super(money);
    }

    public static KoreaMoney from(int money) {
        validate(money);
        return new KoreaMoney(money);
    }

    public static KoreaMoney sub(Money money1, Money money2) {
        return new KoreaMoney(money1.money - money2.money);
    }

    @Override
    public String toString() {
        return String.format("%,d원", money);
    }
}
