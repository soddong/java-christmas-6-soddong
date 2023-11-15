package christmas.domain.event.policy.gift;

import christmas.domain.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.event.EventCondition;

public class FoodGiftPolicy implements GiftPolicy {
    private FoodItem gift;
    private long threshold;

    public FoodGiftPolicy(FoodItem item, long threshold) {
        this.gift = item;
        this.threshold = threshold;
    }

    @Override
    public FoodItem receiveGift(Orders orders) {
        if (isValidForCondition(orders))
            return gift;
        return null;
    }

    @Override
    public boolean isValidForCondition(Orders orders) {
        return EventCondition.isOrderPricesAboveThreshold(orders, threshold);
    }
}
