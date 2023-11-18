package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.food.FoodName;
import org.junit.jupiter.api.Test;

class FoodNameTest {

    @Test
    void 음식이름이_비어있다면_예외처리_발생() {
        assertThatThrownBy(() -> FoodName.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}