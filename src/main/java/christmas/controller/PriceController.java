package christmas.controller;

import christmas.domain.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import java.util.List;

public class PriceController {
    private final PriceCalculator priceCalculator;

    public PriceController(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public Money getDiscountedPrice(Money originPrice, Money discountPrice) {
        return KoreaMoney.sub(originPrice, discountPrice);
    }

    public Money applyGift(List<FoodItem> gifts) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalGifts(gifts)
        );
    }

    public Money applyDiscount(Orders orders) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalDiscount(orders)
        );
    }

}
