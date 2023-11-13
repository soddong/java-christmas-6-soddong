package christmas.domain.discount;

import christmas.domain.Orders;
import christmas.domain.calendar.DayChecker;

import java.time.LocalDate;

public class SpecialDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate))
            return 0;
        return 1000;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DayChecker dayChecker = new DayChecker(date);
        return dayChecker.isSpecialDay();
    }
}
