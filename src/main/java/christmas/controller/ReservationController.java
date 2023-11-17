package christmas.controller;

import static christmas.view.OutputPrinter.OUTPUT_ORIGIN_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PROFIT_MESSAGE;

import christmas.domain.FoodItem;
import christmas.domain.event.Grade;
import christmas.domain.order.Orders;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.RateService;
import christmas.view.OutputManager;
import java.util.List;

public class ReservationController {
    private final OrderService orderService;
    private final EventService eventService;
    private final PriceService priceService;
    private final RateService rateService;

    public ReservationController(OrderService orderService, EventService eventService,
                                 PriceService priceService, RateService rateService) {
        this.orderService = orderService;
        this.eventService = eventService;
        this.priceService = priceService;
        this.rateService = rateService;
    }

    public void reserve() {
        Orders orders = orderService.createOrder();
        OutputManager.displayOrder(orders);

        Money originPrice = eventService.getOriginPrice(orders);
        OutputManager.displayMoney(originPrice, OUTPUT_ORIGIN_PRICE_MESSAGE);

        List<FoodItem> gifts = eventService.receiveGift(orders);
        OutputManager.displayGifts(gifts);

        Money giftPrice = priceService.applyGift(gifts);
        Money discountPrice = priceService.applyDiscount(orders);
        OutputManager.displayMoney(KoreaMoney.add(giftPrice, discountPrice), OUTPUT_TOTAL_PROFIT_MESSAGE);

        Money discountedPrice = priceService.getDiscountedPrice(originPrice, discountPrice);
        OutputManager.displayMoney(discountedPrice, OUTPUT_TOTAL_PRICE_MESSAGE);

        Grade grade = rateService.determineGrade(KoreaMoney.add(giftPrice, discountPrice));
        OutputManager.displayGrade(grade);
    }
}