package christmas.service;

import christmas.domain.food.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import java.util.List;

public class EventService {
    private final PriceCalculator priceCalculator;

    public EventService(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public List<FoodItem> receiveGift(Orders orders) {
        return priceCalculator.receiveGifts(orders);
    }

    public Money getGiftProfits(List<FoodItem> gifts) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalGifts(gifts)
        );
    }

    public Money getDiscountProfits(Orders orders) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalDiscount(orders)
        );
    }
}
