package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WeekdaysDiscountPolicyTest {
    DiscountPolicy discountPolicy;

    @Test
    public void 평일이고_디저트구매시_할인적용_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        Order order1 = Order.of(FoodName.from("초코케이크"), Quantity.from("1"));
        // when
        orders.addOrder(order1);
        discountPolicy = new WeekdaysDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(2023);
    }

    @Test
    public void 주말이고_디저트구매시_할인적용_되지않음() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 2));  // 토요일
        Order order1 = Order.of(FoodName.from("초코케이크"), Quantity.from("1"));
        // when
        orders.addOrder(order1);
        discountPolicy = new WeekdaysDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }

    @Test
    public void 평일이고_디저트구매하지않을시_할인적용_되지않음() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        Order order1 = Order.of(FoodName.from("티본스테이크"), Quantity.from("1"));
        // when
        orders.addOrder(order1);
        discountPolicy = new WeekdaysDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }

    @Test
    public void 조건만족시_디저트_개수만큼_할인적용() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 3));  // 일요일
        Order order1 = Order.of(FoodName.from("아이스크림"), Quantity.from("1"));
        Order order2 = Order.of(FoodName.from("초코케이크"), Quantity.from("1"));

        // when
        orders.addOrder(order1);
        orders.addOrder(order2);
        discountPolicy = new WeekdaysDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(2023*2);
    }

}