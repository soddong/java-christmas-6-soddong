package christmas.domain;

import java.time.LocalDate;

public class WeekdaysDiscountPolicy implements DiscountPolicy{
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(Orders orders) {
        LocalDate orderDate = orders.getDate();
        if (!isValidForCondition(orderDate))
            return 0;
        int count = orders.getOrders().stream()
                .filter(order -> order.menu().getCategory() == FoodCategory.DESSERT)
                .mapToInt(Order::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DayChecker dayChecker = new DayChecker(date);
        return dayChecker.isBetweenRange(start, end) && dayChecker.isWeekDay();
    }
}
