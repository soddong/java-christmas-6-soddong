package christmas.domain.event.policy;

import christmas.domain.event.policy.discount.DdayDiscountPolicy;
import christmas.domain.event.policy.discount.DiscountPolicy;
import christmas.domain.event.policy.discount.SpecialDiscountPolicy;
import christmas.domain.event.policy.discount.WeekdaysDiscountPolicy;
import christmas.domain.event.policy.discount.WeekendDiscountPolicy;
import christmas.domain.event.policy.gift.FoodGiftPolicy;
import christmas.domain.event.policy.gift.GiftPolicy;
import christmas.dto.ItemDto;
import java.util.ArrayList;
import java.util.List;

public class PolicyManager {
    private static final int THRESHOLD_OF_SHAMPAIN_GIFT = 120_000;

    private List<DiscountPolicy> discountPolicies = new ArrayList<>();
    List<GiftPolicy> giftPolicies = new ArrayList<>();

    public PolicyManager() {
        initialze();
    }

    private void initialze() {
        discountPolicies.add(new DdayDiscountPolicy());
        discountPolicies.add(new WeekdaysDiscountPolicy());
        discountPolicies.add(new WeekendDiscountPolicy());
        discountPolicies.add(new SpecialDiscountPolicy());
        giftPolicies.add(new FoodGiftPolicy(ItemDto.createItem("샴페인", "1")
                , THRESHOLD_OF_SHAMPAIN_GIFT));
    }

    public List<DiscountPolicy> getActiveDiscountPolicies() {
        return discountPolicies;
    }

    public List<GiftPolicy> getActiveGiftPolicies() {
        return giftPolicies;
    }
}
