package christmas.service;

import christmas.domain.order.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;

public class PriceService {
    private final PriceCalculator priceCalculator;

    public PriceService(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public Money getOriginPrice(Orders orders) {
        return KoreaMoney.from(
                priceCalculator.calculateItemsPrice(orders.getOrders())
        );
    }

    public Money getTotalPrice(Money originPrice, Money discountPrice) {
        return KoreaMoney.sub(originPrice, discountPrice);
    }
}
