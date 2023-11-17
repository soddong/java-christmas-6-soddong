package christmas.service;

import christmas.domain.event.policy.PolicyManager;
import christmas.domain.event.policy.discount.DiscountPolicy;
import christmas.domain.event.policy.gift.GiftPolicy;
import christmas.domain.food.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventService {
    private final PriceCalculator priceCalculator;
    private final PolicyManager policyManager;

    public EventService(PriceCalculator priceCalculator, PolicyManager policyManager) {
        this.priceCalculator = priceCalculator;
        this.policyManager = policyManager;
    }

    public Optional<List<FoodItem>> receiveGift(Orders orders) {
        List<FoodItem> giftItems = new ArrayList<>();
        for (GiftPolicy policy : policyManager.getActiveGiftPolicies()) {
            policy.receiveGift(orders).ifPresent(giftItems::add);
        }
        return Optional.of(giftItems);
    }

    public Money getGiftProfits(List<FoodItem> gifts) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalGifts(gifts)
        );
    }

    public Money getDiscountProfits(Orders orders) {
        Money profits = KoreaMoney.none();
        for (DiscountPolicy policy : policyManager.getActiveDiscountPolicies()) {
            KoreaMoney.add(profits, KoreaMoney.from(policy.calculateDiscountAmount(orders)));
        }
        return profits;
    }
}
