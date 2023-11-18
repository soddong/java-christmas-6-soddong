package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.dto.OrdersDto;
import java.time.LocalDate;

public class SpecialDiscountPolicy implements DiscountPolicy {
    public static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    @Override
    public int calculateDiscountAmount(final OrdersDto ordersDto) {
        LocalDate orderDate = ordersDto.date();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(ordersDto)) {
            return 0;
        }
        return SPECIAL_DISCOUNT_AMOUNT;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isSpecialDay();
    }

    @Override
    public String toString() {
        return String.format("특별 할인: -%,d원", SPECIAL_DISCOUNT_AMOUNT);
    }
}
