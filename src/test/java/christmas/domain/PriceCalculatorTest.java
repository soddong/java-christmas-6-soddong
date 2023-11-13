package christmas.domain;

import christmas.domain.promotion.discount.DdayDiscountPolicy;
import christmas.domain.promotion.discount.DiscountPolicy;
import christmas.domain.promotion.discount.SpecialDiscountPolicy;
import christmas.domain.promotion.discount.WeekdaysDiscountPolicy;
import christmas.domain.promotion.discount.WeekendDiscountPolicy;
import christmas.domain.price.PriceCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class PriceCalculatorTest {
    List<DiscountPolicy> discountPolicies = new ArrayList<>();
    PriceCalculator calculator;
    @BeforeEach
    void setUp() {
        discountPolicies.add(new DdayDiscountPolicy()); // 1000 + n*100
        discountPolicies.add(new WeekdaysDiscountPolicy()); // 디저트 2023원
        discountPolicies.add(new WeekendDiscountPolicy());  // 메인 메뉴 2023원
        discountPolicies.add(new SpecialDiscountPolicy()); // 무조건 1000
        calculator = new PriceCalculator(discountPolicies);

    }
    @Test
    void 디데이할인_평일할인() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 4)); // 월 & 3일 경과
        FoodItem order = FoodItem.createItem("초코케이크", "2");
        orders.addOrder(order);

        // when
        int price = calculator.calculateDiscountedPrice(orders);

        // then
        Assertions.assertThat(price).isEqualTo(24654);
    }

    @Test
    void 스페셜할인_평일할인_디데이할인() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 24)); // 월 & 23일 경과
        FoodItem order = FoodItem.createItem("초코케이크", "2");
        orders.addOrder(order);

        // when
        int price = calculator.calculateDiscountedPrice(orders);

        // then
        Assertions.assertThat(price).isEqualTo(21654);
    }

    @Test
    void 주말할인_디데이할인() {
        // given  199,000 - 6,500 -> 192,500
        Orders orders = new Orders(LocalDate.of(2023, 12, 16)); // 토 & 15일 경과
        FoodItem order1 = FoodItem.createItem("초코케이크", "2");
        FoodItem order2 = FoodItem.createItem("타파스", "2");
        FoodItem order3 = FoodItem.createItem("바비큐립", "2");
        FoodItem order4 = FoodItem.createItem("샴페인", "2");
        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);
        orders.addOrder(order4);

        // when
        int price = calculator.calculateDiscountedPrice(orders);

        // then
        Assertions.assertThat(price).isEqualTo(192454);
    }

    @Test
    void 스페셜데이_평일할인() {
        // given  199,000 - 6,500 -> 192,500
        Orders orders = new Orders(LocalDate.of(2023, 12, 31)); // 토 & 15일 경과
        FoodItem order1 = FoodItem.createItem("초코케이크", "2");
        orders.addOrder(order1);
        // when
        int price = calculator.calculateDiscountedPrice(orders);

        // then
        Assertions.assertThat(price).isEqualTo(24954);
    }
}