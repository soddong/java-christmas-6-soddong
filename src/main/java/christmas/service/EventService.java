package christmas.service;

import christmas.domain.event.policy.PolicyManager;
import christmas.domain.event.policy.discount.DiscountPolicy;
import christmas.domain.event.policy.gift.GiftPolicy;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.dto.ItemDto;
import christmas.dto.OrdersDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventService {
    private final PolicyManager policyManager;

    public EventService(PolicyManager policyManager) {
        this.policyManager = policyManager;
    }

    public Optional<List<ItemDto>> receiveGift(final OrdersDto ordersDto) {
        List<ItemDto> giftItemDtos = new ArrayList<>();
        for (GiftPolicy policy : policyManager.getActiveGiftPolicies()) {
            policy.receiveGift(ordersDto).ifPresent(giftItemDtos::add);
        }
        return Optional.of(giftItemDtos);
    }

    public Money getDiscountProfits(final OrdersDto ordersDto) {
        Money profits = KoreaMoney.none();
        for (DiscountPolicy policy : policyManager.getActiveDiscountPolicies()) {
            profits = KoreaMoney.add(profits, KoreaMoney.from(policy.calculateDiscountAmount(ordersDto)));
        }
        return profits;
    }

    public Money getGiftProfits(final List<ItemDto> gifts) {
        return KoreaMoney.from(
                PriceCalculator.calculateItemsPrice(gifts)
        );
    }

    public Optional<List<String>> getDetailProfits() {
        List<String> details = new ArrayList<>();
        for (DiscountPolicy policy : policyManager.getActiveDiscountPolicies()) {
            details.add(policy.toString());
        }
        for (GiftPolicy policy : policyManager.getActiveGiftPolicies()) {
            details.add(policy.toString());
        }
        return Optional.of(details);
    }
}
