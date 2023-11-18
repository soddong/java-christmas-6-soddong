package christmas.domain.event.policy.discount;

import christmas.domain.calendar.DateChecker;
import christmas.domain.event.EventCondition;
import christmas.domain.food.FoodCategory;
import christmas.domain.food.Menu;
import christmas.dto.ItemDto;
import christmas.dto.OrdersDto;
import java.time.LocalDate;

public class WeekdaysDiscountPolicy implements DiscountPolicy {
    public static final int WEEKDAY_DISCOUNT_PER_MAINDISH = 2023;

    private final LocalDate start = LocalDate.of(2023, 12, 1);
    private final LocalDate end = LocalDate.of(2023, 12, 31);

    private int discountAmount = 0;

    @Override
    public int calculateDiscountAmount(final OrdersDto ordersDto) {
        LocalDate orderDate = ordersDto.date();
        if (!isValidForCondition(orderDate)
                || !EventCondition.isOrderPricesAboveThreshold(ordersDto)) {
            return 0;
        }
        int count = ordersDto.orders().stream()
                .filter(order -> Menu.from(order.getName()).getCategory() == FoodCategory.DESSERT)
                .mapToInt(ItemDto::getQuantity)
                .sum();
        discountAmount = count * WEEKDAY_DISCOUNT_PER_MAINDISH;
        return discountAmount;
    }

    @Override
    public boolean isValidForCondition(LocalDate date) {
        DateChecker dayChecker = new DateChecker(date);
        return dayChecker.isBetweenRange(start, end) && dayChecker.isWeekDay();
    }

    @Override
    public String toString() {
        return String.format("평일 할인: -%,d원", discountAmount);
    }
}
