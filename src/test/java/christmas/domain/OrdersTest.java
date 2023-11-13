package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersTest {

    private Orders orders = new Orders();
    private String main = "양송이스프";
    private String drink = "제로콜라";
    private String count = "1";

    @Test
    void 주문을_추가한다() {
        // given
        FoodItem order1 = FoodItem.createItem(main, count);
        FoodItem order2 = FoodItem.createItem(drink, count);

        // when & then
        assertDoesNotThrow(() -> orders.addOrder(order1));
        assertDoesNotThrow(() -> orders.addOrder(order2));
        assertEquals(2, orders.getOrders().size());
    }

    @Test
    void 최대주문_가능항목을_초과하면_예외가_발생한다() {
        // given
        String overCount = "11";
        FoodItem order = FoodItem.createItem(main, overCount);
        FoodItem order2 = FoodItem.createItem(main, overCount);
        // when
        orders.addOrder(order);
        // then
        assertThatThrownBy(() -> orders.addOrder(order2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료만_주문했을때는_예외가_발생한다() {
        // when
        FoodItem drinkOrder = FoodItem.createItem(drink, count);
        // then
        assertThrows(IllegalArgumentException.class, () -> orders.addOrder(drinkOrder));
    }
}
