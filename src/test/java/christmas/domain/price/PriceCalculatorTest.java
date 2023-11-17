package christmas.domain.price;

import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    void 테스트() {
        List<Item> orderList = new ArrayList<>();
        Item item = Item.createItem("샴페인", "1");
//        Assertions.assertThat(item.menu().getPrice()).isEqualTo(25000);
        orderList.add(item);
        OrdersDto ordersDto = OrdersDto.createOf(orderList, LocalDate.of(2023, 12, 25));
//        Assertions.assertThat(ordersDto.getOrders()).containsExactly(item);
        Assertions.assertThat(priceCalculator.receiveGifts(ordersDto)).contains(item);
//        int result = priceCalculator.calculateTotalGifts(priceCalculator.receiveGifts(ordersDto));
//        Assertions.assertThat(result).isEqualTo(25000);
    }

//    @Test
//    void calculateDiscountedPrice() {
//        // given
//        OrdersDto orders = new OrdersDto(LocalDate.of(2023, 12, 24)); // 월 & 23일 경과 & 스페셜데이
//        orders.addOrder(Item.createItem("초코케이크", "2"));
//
//        // when
//        int discountedPrice = priceCalculator.calculateDiscountedPrice(orders);
//
//        // then
//        Assertions.assertThat(discountedPrice).isEqualTo(21654);
//    }

}
