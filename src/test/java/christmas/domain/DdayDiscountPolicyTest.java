package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DdayDiscountPolicyTest {
    Order order1;
    Order order2;
    DiscountPolicy discountPolicy;

    @BeforeEach
    void setUp() {
        order1 = Order.of(FoodName.from("양송이스프"), Quantity.from("1"));
        order2 = Order.of(FoodName.from("제로콜라"), Quantity.from("1"));
    }

    // 조건에 해당되는 경우, 할인율을 계산하고 맞는지 확인
    @Test
    public void _12월1일_부터_12월31일_사이인경우_디데이할인이_적용된다_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 1));
        orders.addOrder(order1);
        orders.addOrder(order2);
        discountPolicy = new DdayDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    public void 적용날짜가_아닌경우_디데이할인이_적용되지않는다() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 11, 1));
        orders.addOrder(order1);
        orders.addOrder(order2);
        discountPolicy = new DdayDiscountPolicy();
        // when
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}