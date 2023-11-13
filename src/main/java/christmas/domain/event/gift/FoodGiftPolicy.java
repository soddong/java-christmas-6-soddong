package christmas.domain.event.gift;

import christmas.domain.FoodItem;
import christmas.domain.Orders;
import christmas.domain.event.EventCondition;
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
        return isValidForCondition(orders)
                ?Optional.of(gift)
                :Optional.empty();
    }

    @Override
    public boolean isValidForCondition(Orders orders) {
        return EventCondition.isOrderPricesAboveThreshold(orders, threshold);
    }
}
