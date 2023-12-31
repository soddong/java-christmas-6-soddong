//package christmas.domain.event.discount;
//
//import christmas.domain.event.food.ItemDto;
//import christmas.dto.OrdersDto;
//import christmas.domain.event.policy.discount.DdayDiscountPolicy;
//import christmas.domain.event.policy.discount.DiscountPolicy;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//class DdayDiscountPolicyTest {
//    ItemDto order1;
//    ItemDto order2;
//    DiscountPolicy discountPolicy;
//
//    @BeforeEach
//    void setUp() {
//        order1 = ItemDto.createItem("양송이스프", "1");
//        order2 = ItemDto.createItem("제로콜라", "1");
//    }
//
//    // 조건에 해당되는 경우, 할인율을 계산하고 맞는지 확인
//    @Test
//    public void _12월1일_부터_12월31일_사이인경우_디데이할인이_적용된다_() {
//        // given
//        OrdersDto orders = new OrdersDto(LocalDate.of(2023, 12, 1));
//        orders.addOrder(order1);
//        orders.addOrder(order2);
//        discountPolicy = new DdayDiscountPolicy();
//        // when
//        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
//        // then
//        Assertions.assertThat(discountedPrice).isEqualTo(1000);
//    }
//
//    @Test
//    public void 적용날짜가_아닌경우_디데이할인이_적용되지않는다() {
//        // given
//        OrdersDto orders = new OrdersDto(LocalDate.of(2023, 11, 1));
//        orders.addOrder(order1);
//        orders.addOrder(order2);
//        discountPolicy = new DdayDiscountPolicy();
//        // when
//        int discountedPrice = discountPolicy.calculateDiscountAmount(orders);
//        // then
//        Assertions.assertThat(discountedPrice).isEqualTo(0);
//    }
//}