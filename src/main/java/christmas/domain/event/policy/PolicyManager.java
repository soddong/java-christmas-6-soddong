package christmas.domain.event.policy;

import christmas.domain.FoodItem;
import christmas.domain.event.policy.discount.DdayDiscountPolicy;
import christmas.domain.event.policy.discount.DiscountPolicy;
import christmas.domain.event.policy.discount.SpecialDiscountPolicy;
import christmas.domain.event.policy.discount.WeekdaysDiscountPolicy;
import christmas.domain.event.policy.discount.WeekendDiscountPolicy;
import christmas.domain.event.policy.gift.FoodGiftPolicy;
import christmas.domain.event.policy.gift.GiftPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PolicyManager {
    private static final int THRESHOLD_OF_SHAMPAIN_GIFT = 120_000;

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
                ,THRESHOLD_OF_SHAMPAIN_GIFT));
        return Optional.of(giftPolicies);
    }
}
