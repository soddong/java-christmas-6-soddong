package christmas.controller;

import static christmas.view.OutputPrinter.OUTPUT_ORIGIN_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PROFIT_MESSAGE;

import christmas.domain.event.Grade;
import christmas.domain.food.FoodItem;
import christmas.domain.order.Orders;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.RateService;
import christmas.view.OutputManager;
import java.util.List;
import java.util.Optional;

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

        Money originPrice = priceService.getOriginPrice(orders);
        OutputManager.displayMoney(originPrice, OUTPUT_ORIGIN_PRICE_MESSAGE);

        Optional<List<FoodItem>> gifts = eventService.receiveGift(orders);
        gifts.ifPresent(OutputManager::displayGifts);
        Money giftPrice = gifts.map(eventService::getGiftProfits)
                .orElse(KoreaMoney.none());

        Money discountPrice = eventService.getDiscountProfits(orders);
        OutputManager.displayMoney(KoreaMoney.add(giftPrice, discountPrice), OUTPUT_TOTAL_PROFIT_MESSAGE);

        Money totaldPrice = priceService.getTotalPrice(originPrice, discountPrice);
        OutputManager.displayMoney(totaldPrice, OUTPUT_TOTAL_PRICE_MESSAGE);

        Grade grade = rateService.determineGrade(KoreaMoney.add(giftPrice, discountPrice));
        OutputManager.displayGrade(grade);
    }
}