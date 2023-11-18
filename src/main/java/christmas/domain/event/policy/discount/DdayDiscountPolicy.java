package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.dto.OrdersDto;
import java.time.LocalDate;

public class DdayDiscountPolicy implements DiscountPolicy {
    public static final int DAY_DISCOUNT_BASE = 1_000;
    public static final int DAY_DISCOUNT_PER_DAY = 100;

    private final LocalDate start = LocalDate.of(2023, 12, 1);
    private final LocalDate end = LocalDate.of(2023, 12, 25);

    private int discountAmount = 0;

    @Override
    public int calculateDiscountAmount(OrdersDto ordersDto) {
        LocalDate orderDate = ordersDto.date();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(ordersDto)) {
            return 0;
        }
        discountAmount = DAY_DISCOUNT_BASE + DAY_DISCOUNT_PER_DAY * (orderDate.getDayOfMonth() - start.getDayOfMonth());
        return discountAmount;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isBetweenRange(start, end);
    }

    @Override
    public String toString() {
        return String.format("크리스마스 디데이 할인: -%,d원", discountAmount);
    }
}
