package christmas.service;

import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.dto.OrdersDto;

public class PriceService {
    private final PriceCalculator priceCalculator;

    public PriceService(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public Money getOriginPrice(OrdersDto ordersDto) {
        return KoreaMoney.from(
                priceCalculator.calculateItemsPrice(ordersDto.getOrders())
        );
    }

    public Money getTotalPrice(Money originPrice, Money discountPrice) {
        return KoreaMoney.sub(originPrice, discountPrice);
    }
}
