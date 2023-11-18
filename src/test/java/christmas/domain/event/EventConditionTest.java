//package christmas.domain.event;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import christmas.domain.event.food.ItemDto;
//import christmas.dto.OrdersDto;
//import org.junit.jupiter.api.Test;
//
//class EventConditionTest {
//
//    @Test
//    void 주문금액이_특정값_이상인지_체크할수있다() {
//        // given
//        OrdersDto orders = new OrdersDto();
//        ItemDto order1 = ItemDto.createItem("아이스크림", "2");
//        orders.addOrder(order1);
//        // when
//        boolean result = EventCondition.isOrderPricesAboveThreshold(orders, 10_000);
//        // when
//        assertTrue(result);
//    }
//
//}