package christmas.domain.event.policy.gift;

import christmas.domain.event.EventCondition;
import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.util.Optional;

public class FoodGiftPolicy implements GiftPolicy {
    private Item gift;
    private long threshold;

    public FoodGiftPolicy(Item item, long threshold) {
        this.gift = item;
        this.threshold = threshold;
    }

    @Override
    public Optional<Item> receiveGift(OrdersDto ordersDto) {
        if (isValidForCondition(ordersDto)) {
            return Optional.of(gift);
        }
        return Optional.empty();
    }

    @Override
    public boolean isValidForCondition(OrdersDto ordersDto) {
        return EventCondition.isOrderPricesAboveThreshold(ordersDto, threshold);
    }
}
