package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.dto.OrdersDto;
import java.time.LocalDate;

public class SpecialDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscountAmount(final OrdersDto ordersDto) {
        LocalDate orderDate = ordersDto.getDate();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(ordersDto)) {
            return 0;
        }
        return 1000;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isSpecialDay();
    }
}
