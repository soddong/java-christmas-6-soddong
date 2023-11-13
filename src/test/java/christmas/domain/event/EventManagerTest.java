package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.FoodItem;
import christmas.domain.Menu;
import christmas.domain.Orders;
import christmas.domain.event.discount.DdayDiscountPolicy;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.event.discount.SpecialDiscountPolicy;
import christmas.domain.event.discount.WeekdaysDiscountPolicy;
import christmas.domain.event.discount.WeekendDiscountPolicy;
import christmas.domain.event.gift.FoodGiftPolicy;
import christmas.domain.event.gift.GiftPolicy;
import christmas.domain.price.PriceCalculator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerTest {
    EventManager eventManager;
    List<DiscountPolicy> discountPolicies = new ArrayList<>();
    List<GiftPolicy> giftPolicies = new ArrayList<>();
    FoodItem item;
    Orders orders = new Orders(LocalDate.of(2023,12,25));

    @BeforeEach
    void setUp() {
        item = FoodItem.createItem("샴페인", "1");
        discountPolicies.add(new WeekdaysDiscountPolicy()); // 디저트 2023원
        discountPolicies.add(new SpecialDiscountPolicy()); // 무조건 1000
        giftPolicies.add(new FoodGiftPolicy(item, 10_000));
        eventManager = new EventManager(discountPolicies, giftPolicies);

        orders.addOrder(FoodItem.createItem("초코케이크", "2"));
    }

    @Test
    void sumDiscounts() {
        // when & then
        assertThat(eventManager.sumDiscounts(orders))
                .isEqualTo(2*2023+1000);
    }

    @Test
    void receiveGifts() {
        // when & then
        assertThat(eventManager.receiveGifts(orders))
                .containsExactly(item);
    }
}