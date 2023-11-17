//package christmas.domain.event.discount;
//
//import christmas.domain.event.food.FoodItem;
//import christmas.domain.order.Orders;
//import christmas.domain.event.policy.discount.DiscountPolicy;
//import christmas.domain.event.policy.discount.WeekendDiscountPolicy;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//class WeekendDiscountPolicyTest {
//    DiscountPolicy discountPolicy = new WeekendDiscountPolicy();
//
//    @Test
//    public void 주말이고_디저트구매시_할인적용_() {
//        // given
//        Orders orders = new Orders(LocalDate.of(2023, 12, 2));  // 토요일
//        FoodItem order1 = FoodItem.createItem("티본스테이크", "1");
//        // when
//        orders.addOrder(order1);
//        // when
//        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
//        // then
//        Assertions.assertThat(discountedPrice).isEqualTo(2023);
//    }
//
//}