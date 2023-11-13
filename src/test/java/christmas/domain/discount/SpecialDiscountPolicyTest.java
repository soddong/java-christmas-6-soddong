package christmas.domain.discount;

import christmas.domain.FoodName;
import christmas.domain.FoodItem;
import christmas.domain.Orders;
import christmas.domain.Quantity;
import christmas.domain.promotion.discount.DiscountPolicy;
import christmas.domain.promotion.discount.SpecialDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SpecialDiscountPolicyTest {
    DiscountPolicy discountPolicy = new SpecialDiscountPolicy();
    @Test
    public void 스페셜데이_인경우_할인적용_() {
        // given
        Orders orders = new Orders(LocalDate.of(2023, 12, 25));
        FoodItem order1 = FoodItem.createItem("티본스테이크", "1");
        // when
        orders.addOrder(order1);
        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
        // then
        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }
}