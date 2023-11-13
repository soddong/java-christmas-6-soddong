package christmas.domain.promotion.gift;

import christmas.domain.FoodItem;
import christmas.domain.FoodName;
import christmas.domain.Money;
import christmas.domain.Orders;
import christmas.domain.Quantity;
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
        return isOverThreshold(orders);
    }

    private boolean isOverThreshold(Orders orders) {
        return orders.getOrders().stream()
                .mapToInt(order -> order.menu().getPrice() * order.getQuantity())
                .sum() >= threshold;
    }
}
