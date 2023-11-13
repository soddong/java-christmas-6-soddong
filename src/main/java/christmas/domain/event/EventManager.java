package christmas.domain.event;

import christmas.domain.FoodItem;
import christmas.domain.Orders;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.event.gift.GiftPolicy;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventManager {
    private List<DiscountPolicy> discountPolicies;
    private List<GiftPolicy> giftPolicies;

    public EventManager(List<DiscountPolicy> discountPolicies, List<GiftPolicy> giftPolicies) {
        this.discountPolicies = discountPolicies;
        this.giftPolicies = giftPolicies;
    }

    public int sumDiscounts(Orders orders) {
        if (!EventCondition.isOrderPricesAboveThreshold(orders, 10_000))
            return 0;
        return discountPolicies.stream()
                .mapToInt(policy -> policy.calculateDiscountAmount(orders))
                .sum();
    }

    public List<FoodItem> receiveGifts(Orders orders) {
        return giftPolicies.stream()
                .map(policy -> policy.receiveGift(orders))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
