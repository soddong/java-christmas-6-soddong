package christmas.domain.event.discount;

import christmas.domain.calendar.Date;
import christmas.domain.FoodCategory;
import christmas.domain.FoodItem;
import christmas.domain.Orders;

import christmas.domain.event.EventCondition;
import java.time.LocalDate;

public class WeekdaysDiscountPolicy implements DiscountPolicy {
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate) || !EventCondition.isOrderPricesAboveThreshold(orders, 10_000))
            return 0;
        int count = orders.getOrders().stream()
                .filter(order -> order.menu().getCategory() == FoodCategory.DESSERT)
                .mapToInt(FoodItem::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        Date dayChecker = new Date(date);
        return dayChecker.isBetweenRange(start, end) && dayChecker.isWeekDay();
    }
}
