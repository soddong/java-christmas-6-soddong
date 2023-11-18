package christmas.domain.event.policy.gift;

import christmas.domain.event.EventCondition;
import christmas.domain.price.PriceCalculator;
import christmas.dto.ItemDto;
import christmas.dto.OrdersDto;
import java.util.Optional;

public class FoodGiftPolicy implements GiftPolicy {
    private final ItemDto gift;
    private final long threshold;

    public FoodGiftPolicy(ItemDto itemDto, long threshold) {
        this.gift = itemDto;
        this.threshold = threshold;
    }

    @Override
    public Optional<ItemDto> receiveGift(final OrdersDto ordersDto) {
        if (isValidForCondition(ordersDto)) {
            return Optional.of(gift);
        }
        return Optional.empty();
    }

    @Override
    public boolean isValidForCondition(final OrdersDto ordersDto) {
        return EventCondition.isOrderPricesAboveThreshold(ordersDto, threshold);
    }

    @Override
    public String toString() {
        return String.format("증정 이벤트: -%,d원", PriceCalculator.calculateItemPrice(gift));
    }
}
