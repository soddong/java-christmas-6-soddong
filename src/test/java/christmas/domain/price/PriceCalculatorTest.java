package christmas.domain.price;

import christmas.domain.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.event.policy.EventManager;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    PriceCalculator priceCalculator = new PriceCalculator(
            new EventManager()
    );

    @Test
    void calculateDiscountedPrice() {
        // given
        Orders orders =  new Orders(LocalDate.of(2023, 12, 24)); // 월 & 23일 경과 & 스페셜데이
        orders.addOrder(FoodItem.createItem("초코케이크", "2"));

        // when
        int discountedPrice = priceCalculator.calculateDiscountedPrice(orders);

        // then
        Assertions.assertThat(discountedPrice).isEqualTo(21654);
    }

}
