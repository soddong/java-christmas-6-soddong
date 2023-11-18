package christmas.service;

import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.dto.OrdersDto;

public class PriceService {
    public Money getOriginPrice(final OrdersDto ordersDto) {
        return KoreaMoney.from(
                PriceCalculator.calculateItemsPrice(ordersDto.orders())
        );
    }

    public Money getTotalPrice(final Money originPrice, final Money discountPrice) {
        return KoreaMoney.sub(originPrice, discountPrice);
    }
}
