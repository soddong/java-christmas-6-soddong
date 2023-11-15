package christmas.domain.event.discount;

import christmas.domain.Orders;
import christmas.domain.calendar.Date;

import christmas.domain.event.EventCondition;
import java.time.LocalDate;

public class SpecialDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate) || !EventCondition.isOrderPricesAboveThreshold(orders, 10_000))
            return 0;
        return 1000;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        Date dayChecker = new Date(date);
        return dayChecker.isSpecialDay();
    }
}
