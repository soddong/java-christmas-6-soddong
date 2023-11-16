package christmas;

import static christmas.view.OutputView.OUTPUT_GIFT_MESSAGE;
import static christmas.view.OutputView.OUTPUT_ORDER_MESSAGE;
import static christmas.view.OutputView.OUTPUT_ORIGIN_PRICE_MESSAGE;
import static christmas.view.OutputView.OUTPUT_TOTAL_PRICE_MESSAGE;
import static christmas.view.OutputView.OUTPUT_TOTAL_PROFIT_MESSAGE;
import static christmas.view.OutputView.newLine;
import static christmas.view.OutputView.printMessage;

import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.controller.PriceController;
import christmas.controller.RateController;
import christmas.domain.FoodItem;
import christmas.domain.event.Grade;
import christmas.domain.order.Orders;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.view.OutputView;
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
        displayOrder(orders);

        Money originPrice = eventController.getOriginPrice(orders);
        displayMoney(originPrice, OUTPUT_ORIGIN_PRICE_MESSAGE);

        List<FoodItem> gifts = eventController.receiveGift(orders);
        displayGifts(gifts);

        Money giftPrice = priceController.applyGift(gifts);
        Money discountPrice = priceController.applyDiscount(orders);
        displayMoney(KoreaMoney.add(giftPrice, discountPrice), OUTPUT_TOTAL_PROFIT_MESSAGE);

        Money discountedPrice = priceController.getDiscountedPrice(originPrice, discountPrice);
        displayMoney(discountedPrice, OUTPUT_TOTAL_PRICE_MESSAGE);

        Grade grade = rateController.determineGrade(KoreaMoney.add(giftPrice, discountPrice));
        displayGrade(grade);
    }

    private void displayGrade(final Grade grade) {
        newLine();
        printMessage(OutputView.OUTPUT_EVENT_BEDGE_MESSAGE);
        printMessage(grade.name());
    }

    private void displayGifts(final List<FoodItem> gifts) {
        newLine();
        printMessage(OUTPUT_GIFT_MESSAGE);
        if (gifts.isEmpty()) {
            printMessage("없음");
        }
        for (FoodItem item : gifts) {
            printMessage(item.toString());
        }
    }

    private void displayOrder(final Orders orders) {
        newLine();
        printMessage(OUTPUT_ORDER_MESSAGE);
        for (FoodItem item : orders.getOrders()) {
            printMessage(item.toString());
        }
    }

    private void displayMoney(final Money price, final String message) {
        newLine();
        printMessage(message);
        printMessage(price.toString());
    }
}