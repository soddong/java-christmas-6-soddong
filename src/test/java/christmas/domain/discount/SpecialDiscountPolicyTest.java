package christmas.domain.discount;

import christmas.domain.FoodName;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.Quantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountPolicyTest {
    DiscountPolicy discountPolicy = new SpecialDiscountPolicy();
    @Test
    public void 스페셜데이_인경우_할인적용_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 25));
        Order order1 = Order.of(FoodName.from("티본스테이크"), Quantity.from("1"));
        // when
        orders.addOrder(order1);
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }
}