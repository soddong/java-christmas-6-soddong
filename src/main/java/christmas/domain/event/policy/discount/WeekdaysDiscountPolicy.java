package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.domain.food.FoodCategory;
import christmas.domain.food.Menu;
import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.time.LocalDate;

public class WeekdaysDiscountPolicy implements DiscountPolicy {
    private LocalDate start = LocalDate.of(2023, 12, 1);
    private LocalDate end = LocalDate.of(2023, 12, 31);

    @Override
    public int calculateDiscountAmount(final OrdersDto ordersDto) {
        LocalDate orderDate = ordersDto.date();
        if (!isValidForCondition(orderDate)
                || !EventCondition.isOrderPricesAboveThreshold(ordersDto)) {
            return 0;
        }
        int count = ordersDto.orders().stream()
                .filter(order -> Menu.from(order.getName()).getCategory() == FoodCategory.DESSERT)
                .mapToInt(Item::getQuantity)
                .sum();
        return count * 2023;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isBetweenRange(start, end) && dayChecker.isWeekDay();
    }
}
