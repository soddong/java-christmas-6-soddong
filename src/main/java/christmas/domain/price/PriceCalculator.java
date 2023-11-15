package christmas.domain.price;

import christmas.domain.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.event.policy.PolicyManager;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PriceCalculator {
    private PolicyManager policyManager;

    public PriceCalculator(PolicyManager policyManager) {
        this.policyManager = policyManager;
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
        return policyManager.getActiveDiscountPolicies()
                .map(policies -> policies
                    .stream()
                    .mapToInt(policy -> policy.calculateDiscountAmount(orders))
                    .sum())
                .orElse(0);
    }

    public List<FoodItem> receiveGifts(Orders orders) {
        return policyManager.getActiveGiftPolicies()
                .stream()
                .flatMap(policies -> policies
                        .stream()
                        .map(policy -> policy.receiveGift(orders))
                        .filter(Objects::nonNull))
                .collect(Collectors.toList());
    }

}
