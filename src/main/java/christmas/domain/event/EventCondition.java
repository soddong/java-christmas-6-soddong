package christmas.domain.event;

import christmas.domain.food.Menu;
import christmas.dto.OrdersDto;

public class EventCondition {
    public static final int EVENT_COMMON_THRESOLD = 10_000;

    public static boolean isOrderPricesAboveThreshold(final OrdersDto ordersDto) {
        return ordersDto.orders().stream()
                .mapToInt(order -> Menu.from(order.getName()).getPrice() * order.getQuantity())
                .sum() >= EVENT_COMMON_THRESOLD;
    }

    public static boolean isOrderPricesAboveThreshold(final OrdersDto ordersDto, final long thresold) {
        return ordersDto.orders().stream()
                .mapToInt(order -> Menu.from(order.getName()).getPrice() * order.getQuantity())
                .sum() >= thresold;
    }
}
