package christmas.domain.price;

import christmas.domain.Orders;
import christmas.domain.event.EventManager;
import christmas.domain.event.discount.DiscountPolicy;

import java.util.List;
import java.util.Optional;

public class PriceCalculator {
    private EventManager eventManager;

    public PriceCalculator(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public int calculateDiscountedPrice(Orders orders) {
        return calculateOriginalPrice(orders) - calculateTotalDiscount(orders);
    }

    public int calculateOriginalPrice(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum();
    }

    public int calculateTotalDiscount(Orders orders) {
        return eventManager.getActiveDiscountPolicies()
                .map(policies -> policies
                .stream()
                .mapToInt(policy -> policy.calculateDiscountAmount(orders))
                .sum()).orElse(0);
    }
}
