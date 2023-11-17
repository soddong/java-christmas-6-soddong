//package christmas.domain.discount;
//
//import christmas.domain.event.food.Item;
//import christmas.dto.OrdersDto;
//import christmas.domain.event.policy.discount.DiscountPolicy;
//import christmas.domain.event.policy.discount.SpecialDiscountPolicy;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//class SpecialDiscountPolicyTest {
//    DiscountPolicy discountPolicy = new SpecialDiscountPolicy();
//    @Test
//    public void 스페셜데이_인경우_할인적용_() {
//        // given
//        OrdersDto orders = new OrdersDto(LocalDate.of(2023, 12, 25));
//        Item order1 = Item.createItem("티본스테이크", "1");
//        // when
//        orders.addOrder(order1);
//        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
//        // then
//        Assertions.assertThat(discountedPrice).isEqualTo(1000);
//    }
//}