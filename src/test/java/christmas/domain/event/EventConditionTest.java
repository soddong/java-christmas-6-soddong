package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.FoodItem;
import christmas.domain.Orders;
import christmas.domain.event.gift.FoodGiftPolicy;
import org.junit.jupiter.api.Test;

class EventConditionTest {

    @Test
    void 주문금액이_특정값_이상인지_체크할수있다() {
        // given
        Orders orders = new Orders();
        FoodItem order1 = FoodItem.createItem("아이스크림", "2");
        orders.addOrder(order1);
        // when
        boolean result = EventCondition.isOrderPricesAboveThreshold(orders, 10_000);
        // when
        assertTrue(result);
    }

}