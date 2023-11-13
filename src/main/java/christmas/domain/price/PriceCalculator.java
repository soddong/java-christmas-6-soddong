package christmas.domain.price;

import christmas.domain.Orders;
import christmas.domain.promotion.discount.DiscountPolicy;

import java.util.List;

public class PriceCalculator {
    private List<DiscountPolicy> discountPolicies;

    public PriceCalculator(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public int calculateDiscountedPrice(Orders orders) {
        int originalPrice = calculateOriginalPrice(orders);
        int totalDiscount = calculateTotalDiscount(orders);
        return originalPrice - totalDiscount;
    }

    private int calculateOriginalPrice(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum();
    }

    private int calculateTotalDiscount(Orders orders) {
        return discountPolicies.stream()
                .mapToInt(discountPolicy -> discountPolicy.calculateDiscountAmount(orders))
                .sum();
    }
}
