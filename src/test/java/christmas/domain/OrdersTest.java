package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        OrderFood orderFood1 = OrderFood.of(main, cnt);
        OrderFood orderFood2 = OrderFood.of(drink, cnt);

        // when & then
        assertDoesNotThrow(() -> orders.addOrderFood(orderFood1));
        assertDoesNotThrow(() -> orders.addOrderFood(orderFood2));
        assertEquals(2, orders.getOrderFoods().size());
    }

    @Test
    void 최대주문_가능항목을_초과하면_예외가_발생한다() {
        // given
        cnt = Quantity.from("11");
        OrderFood orderFood = OrderFood.of(main, cnt);
        OrderFood orderFood2 = OrderFood.of(main, cnt);
        // when
        orders.addOrderFood(orderFood);
        // then
        assertThatThrownBy(() -> orders.addOrderFood(orderFood2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료만_주문했을때는_예외가_발생한다() {
        // given
        cnt = Quantity.from("1");
        // when
        OrderFood drinkOrder = OrderFood.of(drink, cnt);
        // then
        assertThrows(IllegalArgumentException.class, () -> orders.addOrderFood(drinkOrder));
    }
}
