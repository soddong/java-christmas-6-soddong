package christmas.domain.discount;

import christmas.domain.DayChecker;
import christmas.domain.FoodCategory;
import christmas.domain.Order;
import christmas.domain.Orders;

import java.time.LocalDate;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate))
            return 0;
        int count = orders.getOrders().stream()
                .filter(order -> order.menu().getCategory() == FoodCategory.MAINDISH)
                .mapToInt(Order::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DayChecker dayChecker = new DayChecker(date);
        return dayChecker.isBetweenRange(start, end) && !dayChecker.isWeekDay();
    }
}
