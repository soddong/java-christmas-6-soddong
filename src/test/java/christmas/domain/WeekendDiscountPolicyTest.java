package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WeekendDiscountPolicyTest {
    DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

    @Test
    public void 주말이고_디저트구매시_할인적용_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 2));  // 토요일
        Order order1 = Order.of(FoodName.from("티본스테이크"), Quantity.from("1"));
        // when
        orders.addOrder(order1);
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(2023);
    }

}