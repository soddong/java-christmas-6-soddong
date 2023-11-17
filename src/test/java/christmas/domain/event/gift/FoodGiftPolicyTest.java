//package christmas.domain.event.gift;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import christmas.domain.event.food.Item;
//import christmas.dto.OrdersDto;
//import christmas.domain.event.policy.gift.FoodGiftPolicy;
//import org.junit.jupiter.api.Test;
//
//class FoodGiftPolicyTest {
//    OrdersDto orders = new OrdersDto();
//    Item order1 = Item.createItem("아이스크림", "5");
//    Item order2 = Item.createItem("초코케이크", "20");
//
//    @Test
//    void 주문금액이_경계값을_넘지못하면_증정품을_받을수없다() {
//        // given
//        FoodGiftPolicy foodGiftPolicy = new FoodGiftPolicy(
//                Item.createItem("샴페인", "1")
//                , 120_000
//        );
//        // when
//        orders.addOrder(order1);
//        assertTrue(foodGiftPolicy.receiveGift(orders).isEmpty());
//    }
//
//    @Test
//    void 주문금액이_경계값을_넘기면_증정품을_받을수있다() {
//        // given
//        Item item = Item.createItem("샴페인", "1");
//        FoodGiftPolicy foodGiftPolicy = new FoodGiftPolicy(item, 120_000);
//        // when
//        orders.addOrder(order2);
//        assertThat(foodGiftPolicy.receiveGift(orders)).containsSame(item);
//    }
//
//}