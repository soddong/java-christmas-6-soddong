package christmas.domain.event;

import christmas.domain.order.Orders;

public class EventCondition {
    public static final int EVENT_COMMON_THRESOLD = 10_000;

    public static boolean isOrderPricesAboveThreshold(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum() >= EVENT_COMMON_THRESOLD;
    }

    public static boolean isOrderPricesAboveThreshold(Orders orders, long thresold) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum() >= thresold;
    }
}
