package christmas.domain.event;

import christmas.domain.price.money.Money;
import java.util.Comparator;
import java.util.stream.Stream;

public enum Grade {
    없음(0),
    별(5_000),
    트리(10_000),
    산타(20_000);

    private final int price;

    private Grade(final int price) {
        this.price = price;
    }

    public static Grade createFrom(final Money price) {
        return Stream.of(Grade.values())
                .filter(grade -> grade.price <= price.money())
                .max(Comparator.comparingInt(g -> g.price))
                .orElse(없음);
    }
}
