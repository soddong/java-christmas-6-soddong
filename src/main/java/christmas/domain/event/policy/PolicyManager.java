package christmas.domain.event.policy;

import christmas.domain.event.policy.discount.DdayDiscountPolicy;
import christmas.domain.event.policy.discount.DiscountPolicy;
import christmas.domain.event.policy.discount.SpecialDiscountPolicy;
import christmas.domain.event.policy.discount.WeekdaysDiscountPolicy;
import christmas.domain.event.policy.discount.WeekendDiscountPolicy;
import christmas.domain.event.policy.gift.FoodGiftPolicy;
import christmas.domain.event.policy.gift.GiftPolicy;
import christmas.domain.food.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class PolicyManager {
    private static final int THRESHOLD_OF_SHAMPAIN_GIFT = 120_000;

    public List<DiscountPolicy> getActiveDiscountPolicies() {
        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new DdayDiscountPolicy());
        discountPolicies.add(new WeekdaysDiscountPolicy());
        discountPolicies.add(new WeekendDiscountPolicy());
        discountPolicies.add(new SpecialDiscountPolicy());
        return discountPolicies;
    }

    public List<GiftPolicy> getActiveGiftPolicies() {
        List<GiftPolicy> giftPolicies = new ArrayList<>();
        giftPolicies.add(new FoodGiftPolicy(FoodItem.createItem("샴페인", "1")
                , THRESHOLD_OF_SHAMPAIN_GIFT));
        return giftPolicies;
    }
}
