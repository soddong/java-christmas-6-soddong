package christmas.domain.event;

import christmas.domain.Orders;

public class EventCondition {
    public static boolean isOrderPricesAboveThreshold(Orders orders, long threshold) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum() >= threshold;
    }
}
