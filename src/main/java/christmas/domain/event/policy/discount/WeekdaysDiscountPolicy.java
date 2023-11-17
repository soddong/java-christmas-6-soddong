package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.domain.food.FoodCategory;
import christmas.domain.food.Menu;
import christmas.domain.order.Orders;
import christmas.dto.FoodItem;
import java.time.LocalDate;

public class WeekdaysDiscountPolicy implements DiscountPolicy {
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(final Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate)
                || !EventCondition.isOrderPricesAboveThreshold(orders)) {
            return 0;
        }
        int count = orders.getOrders().stream()
                .filter(order -> Menu.from(order.getName()).getCategory() == FoodCategory.DESSERT)
                .mapToInt(FoodItem::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isBetweenRange(start, end) && dayChecker.isWeekDay();
    }
}
