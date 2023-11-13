package christmas.domain;

import christmas.domain.promotion.discount.DiscountPolicy;
import christmas.domain.promotion.discount.WeekdaysDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WeekdaysDiscountPolicyTest {
    DiscountPolicy discountPolicy = new WeekdaysDiscountPolicy();

    @Test
    public void 평일이고_디저트구매시_할인적용_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        FoodItem order1 = FoodItem.createItem("초코케이크", "1");
        // when
        orders.addOrder(order1);
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(2023);
    }

    @Test
    public void 주말이고_디저트구매시_할인적용_되지않음() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 2));  // 토요일
        FoodItem order1 = FoodItem.createItem("초코케이크", "1");
        // when
        orders.addOrder(order1);
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }

    @Test
    public void 평일이고_디저트구매하지않을시_할인적용_되지않음() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        FoodItem order1 = FoodItem.createItem("티본스테이크", "1");
        // when
        orders.addOrder(order1);
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }

    @Test
    public void 조건만족시_디저트_개수만큼_할인적용() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        FoodItem order1 = FoodItem.createItem("아이스크림", "1");
        FoodItem order2 = FoodItem.createItem("초코케이크", "1");

        // when
        orders.addOrder(order1);
        orders.addOrder(order2);
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(2023*2);
    }

}