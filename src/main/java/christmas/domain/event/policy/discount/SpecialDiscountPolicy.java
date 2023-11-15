package christmas.domain.event.policy.discount;

import christmas.domain.calendar.Date;
import christmas.domain.event.EventCondition;
import christmas.domain.order.Orders;
import java.time.LocalDate;

public class SpecialDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(orders)) {
            return 0;
        }
        return 1000;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        Date dayChecker = new Date(date);
        return dayChecker.isSpecialDay();
    }
}
