package christmas.domain;

import java.util.List;

public class PriceCalculator {
    private List<DiscountPolicy> discountPolicies;

    public PriceCalculator(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public int calculateOriginPrice(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum();
    }

    public int calculateDiscountedPrice(int originPrice) {
        // 할인된 가격 계산 로직
        return originPrice;
    }
}
