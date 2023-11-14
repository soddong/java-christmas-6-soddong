package christmas.domain.event;

import christmas.domain.FoodItem;
import christmas.domain.Orders;
import christmas.domain.event.discount.DdayDiscountPolicy;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.event.discount.SpecialDiscountPolicy;
import christmas.domain.event.discount.WeekdaysDiscountPolicy;
import christmas.domain.event.discount.WeekendDiscountPolicy;
import christmas.domain.event.gift.FoodGiftPolicy;
import christmas.domain.event.gift.GiftPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventManager {
    private static final int THRESHOLD_SHAMPAIN_GIFT_POLICY = 120_000;

    public Optional<List<DiscountPolicy>> getActiveDiscountPolicies() {
        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new DdayDiscountPolicy());
        discountPolicies.add(new WeekdaysDiscountPolicy());
        discountPolicies.add(new WeekendDiscountPolicy());
        discountPolicies.add(new SpecialDiscountPolicy());
        return Optional.of(discountPolicies);
    }

    public Optional<List<GiftPolicy>> getActiveGiftPolicies() {
        List<GiftPolicy> giftPolicies = new ArrayList<>();
        giftPolicies.add(new FoodGiftPolicy(FoodItem.createItem("샴페인", "1")
                ,THRESHOLD_SHAMPAIN_GIFT_POLICY));
        return Optional.of(giftPolicies);
    }
}
