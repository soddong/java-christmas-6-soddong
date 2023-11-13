package christmas.domain;

import java.time.LocalDate;
import java.util.Date;

public class DdayDiscountPolicy implements DiscountPolicy {
    private final static LocalDate christmas = LocalDate.of(2023, 12, 25);
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 25);

    // * 1000원으로 시작하여 크리스마스 다가올수록 100원 증가
    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate)) {
            return 0;
        }
        return 1000 + 100 * (christmas.getDayOfMonth() - orderDate.getDayOfMonth());
    }

    // (12/1 ~ 12/25)
    @Override
    public boolean isValidForCondition(LocalDate date) {
        return (!date.isBefore(start) && !date.isAfter(end));
    }
}
