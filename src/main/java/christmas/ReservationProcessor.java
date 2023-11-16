package christmas;

import static christmas.view.OutputPrinter.OUTPUT_ORIGIN_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PRICE_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PROFIT_MESSAGE;

import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.controller.PriceController;
import christmas.controller.RateController;
import christmas.domain.FoodItem;
import christmas.domain.event.Grade;
import christmas.domain.order.Orders;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.view.OutputManager;
import java.util.List;

public class ReservationProcessor {
    private final OrderController orderController;
    private final EventController eventController;
    private final PriceController priceController;
    private final RateController rateController;

    public ReservationProcessor(OrderController orderController, EventController eventController,
                                PriceController priceController, RateController rateController) {
        this.orderController = orderController;
        this.eventController = eventController;
        this.priceController = priceController;
        this.rateController = rateController;
    }

    public void start() {
        Orders orders = orderController.createOrder();
        OutputManager.displayOrder(orders);

        Money originPrice = eventController.getOriginPrice(orders);
        OutputManager.displayMoney(originPrice, OUTPUT_ORIGIN_PRICE_MESSAGE);

        List<FoodItem> gifts = eventController.receiveGift(orders);
        OutputManager.displayGifts(gifts);

        Money giftPrice = priceController.applyGift(gifts);
        Money discountPrice = priceController.applyDiscount(orders);
        OutputManager.displayMoney(KoreaMoney.add(giftPrice, discountPrice), OUTPUT_TOTAL_PROFIT_MESSAGE);

        Money discountedPrice = priceController.getDiscountedPrice(originPrice, discountPrice);
        OutputManager.displayMoney(discountedPrice, OUTPUT_TOTAL_PRICE_MESSAGE);

        Grade grade = rateController.determineGrade(KoreaMoney.add(giftPrice, discountPrice));
        OutputManager.displayGrade(grade);
    }
}