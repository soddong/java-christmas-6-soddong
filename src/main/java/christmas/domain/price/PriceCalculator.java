package christmas.domain.price;

import christmas.domain.FoodItem;
import christmas.domain.event.policy.PolicyManager;
import christmas.domain.order.Orders;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PriceCalculator {
    private PolicyManager policyManager;

    public PriceCalculator(PolicyManager policyManager) {
        this.policyManager = policyManager;
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
                .map(policies -> policies.stream()
                        .map(policy -> policy.receiveGift(orders))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }


    public int calculateTotalGifts(List<FoodItem> items) {
        return items.stream()
                .mapToInt(item -> item.menu().getPrice() * item.getQuantity())
                .sum();
    }

}
