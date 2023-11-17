package christmas.domain.price.money;

public class KoreaMoney extends Money {
    public KoreaMoney(int money) {
        super(money);
    }

    public static KoreaMoney from(int money) {
        validate(money);
        return new KoreaMoney(money);
    }

    public static KoreaMoney sub(Money base, Money comparison) {
        return new KoreaMoney(base.money - comparison.money);
    }

    public static Money add(Money base, Money comparison) {
        return new KoreaMoney(base.money + comparison.money);
    }

    public static Money none() {
        return new KoreaMoney(0);
    }

    @Override
    public String toString() {
        return String.format("%,d원", money);
    }
}
