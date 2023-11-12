package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderFoodTest {

    @Test
    void 주문_생성_성공() {
        // given
        FoodName foodName = FoodName.from("티본스테이크");
        Quantity quantity = Quantity.from("1");
        // when
        OrderFood order = OrderFood.of(foodName, quantity);
        // then
        assertNotNull(order);
    }

    @Test
    void 메뉴판에_없는_메뉴를_주문시_예외발생() {
        // given
        FoodName foodName = FoodName.from("아무거나");
        Quantity quantity = Quantity.from("1");
        // when & then
        assertThatThrownBy(()
                -> OrderFood.of(foodName, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_수량_반환() {
        // given
        FoodName foodName = FoodName.from("티본스테이크");
        Quantity quantity = Quantity.from("1");
        // when
        OrderFood order = OrderFood.of(foodName, quantity);
        // then
        assertEquals(quantity.getQuantity(), order.getQuantity());
        assertEquals(Menu.from(foodName), order.menu());
    }
}