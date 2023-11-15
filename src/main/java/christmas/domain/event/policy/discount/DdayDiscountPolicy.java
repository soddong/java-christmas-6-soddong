package christmas.domain.event.policy.discount;

import christmas.domain.calendar.Date;
import christmas.domain.event.EventCondition;
import christmas.domain.order.Orders;
import java.time.LocalDate;

public class DdayDiscountPolicy implements DiscountPolicy {
    public static final int DAY_DISCOUNT_BASE = 1_000;
    public static final int DAY_DISCOUNT_PER_DAY = 100;


    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 25);

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(orders)) {
            return 0;
        }
        return DAY_DISCOUNT_BASE + DAY_DISCOUNT_PER_DAY * (orderDate.getDayOfMonth() - start.getDayOfMonth());
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        Date dayChecker = new Date(date);
        return dayChecker.isBetweenRange(start, end);
    }
}
