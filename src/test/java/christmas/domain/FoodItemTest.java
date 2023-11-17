package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.food.FoodItem;
import org.junit.jupiter.api.Test;

class FoodItemTest {

    String name = "티본스테이크";
    String quantity = "1";

    @Test
    void 주문_생성_성공() {
        // when
        FoodItem order = FoodItem.createItem(name, quantity);
        // then
        assertNotNull(order);
    }

    @Test
    void 메뉴판에_없는_메뉴를_주문시_예외발생() {
        // when & then
        assertThatThrownBy(()
                -> FoodItem.createItem("아무거나", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_수량_반환() {
        // when
        FoodItem order = FoodItem.createItem(name, quantity);
        // then
        assertEquals(quantity, order.getQuantity());
        assertEquals(name, order.menu());
    }
}