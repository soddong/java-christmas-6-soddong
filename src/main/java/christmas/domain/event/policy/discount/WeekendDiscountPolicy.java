package christmas.domain.event.policy.discount;

import christmas.domain.FoodItem;
import christmas.domain.calendar.Date;
import christmas.domain.event.EventCondition;
import christmas.domain.order.FoodCategory;
import christmas.domain.order.Orders;
import java.time.LocalDate;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(final Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate) ||
                !EventCondition.isOrderPricesAboveThreshold(orders)) {
            return 0;
        }
        int count = orders.getOrders().stream()
                .filter(order -> order.menu().getCategory() == FoodCategory.MAINDISH)
                .mapToInt(FoodItem::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        Date dayChecker = new Date(date);
        return dayChecker.isBetweenRange(start, end) && !dayChecker.isWeekDay();
    }
}
