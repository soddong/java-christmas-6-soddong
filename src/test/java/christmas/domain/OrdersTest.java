package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersTest {

    private Orders orders;
    private FoodName main;
    private FoodName drink;
    private Quantity cnt;

    @BeforeEach
    void setUp() {
        orders = new Orders();
        main = FoodName.from("양송이스프");
        drink = FoodName.from("제로콜라");
        cnt = Quantity.from("1");
    }

    @Test
    void 주문을_추가한다() {
        // given
        Order order1 = Order.of(main, cnt);
        Order order2 = Order.of(drink, cnt);

        // when & then
        assertDoesNotThrow(() -> orders.addOrder(order1));
        assertDoesNotThrow(() -> orders.addOrder(order2));
        assertEquals(2, orders.getOrders().size());
    }

    @Test
    void 최대주문_가능항목을_초과하면_예외가_발생한다() {
        // given
        cnt = Quantity.from("11");
        Order order = Order.of(main, cnt);
        Order order2 = Order.of(main, cnt);
        // when
        orders.addOrder(order);
        // then
        assertThatThrownBy(() -> orders.addOrder(order2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료만_주문했을때는_예외가_발생한다() {
        // given
        cnt = Quantity.from("1");
        // when
        Order drinkOrder = Order.of(drink, cnt);
        // then
        assertThrows(IllegalArgumentException.class, () -> orders.addOrder(drinkOrder));
    }
}
