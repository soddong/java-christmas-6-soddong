package christmas.domain.event.policy.gift;

import christmas.domain.FoodItem;
import christmas.domain.event.EventCondition;
import christmas.domain.order.Orders;
import java.util.Optional;

public class FoodGiftPolicy implements GiftPolicy {
    private FoodItem gift;
    private long threshold;

    public FoodGiftPolicy(FoodItem item, long threshold) {
        this.gift = item;
        this.threshold = threshold;
    }

    @Override
    public Optional<FoodItem> receiveGift(Orders orders) {
        if (isValidForCondition(orders)) {
            return Optional.of(gift);
        }
        return Optional.empty();
    }

    @Override
    public boolean isValidForCondition(Orders orders) {
        return EventCondition.isOrderPricesAboveThreshold(orders, threshold);
    }
}
