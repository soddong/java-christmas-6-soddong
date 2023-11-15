package christmas.controller;

import static christmas.view.OutputView.OUTPUT_GIFT_MESSAGE;
import static christmas.view.OutputView.OUTPUT_ORDER_MESSAGE;
import static christmas.view.OutputView.OUTPUT_ORIGIN_PRICE_MESSAGE;
import static christmas.view.OutputView.OUTPUT_TOTAL_PRICE_MESSAGE;
import static christmas.view.OutputView.OUTPUT_TOTAL_PROFIT_MESSAGE;
import static christmas.view.OutputView.newLine;
import static christmas.view.OutputView.printMessage;

import christmas.domain.FoodItem;
import christmas.domain.event.Grade;
import christmas.domain.order.OrderMaker;
import christmas.domain.order.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.domain.price.money.KoreaMoney;
import christmas.domain.price.money.Money;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class EventController {
    private final InputView inputView;
    private final OrderMaker orderMaker;
    private final PriceCalculator priceCalculator;

    public EventController(InputView inputView, OrderMaker orderMaker,
                           PriceCalculator priceCalculator) {
        this.inputView = inputView;
        this.orderMaker = orderMaker;
        this.priceCalculator = priceCalculator;
    }

    public void start() {
        createDate();
        createMenu();
        Orders orders = orderMaker.build();
        displayOrder(orders);

        Money originPrice = getOriginPrice(orders);
        displayMoney(originPrice, OUTPUT_ORIGIN_PRICE_MESSAGE);

        List<FoodItem> gifts = receiveGift(orders);
        displayGifts(gifts);

        Money giftPrice = applyGift(gifts);
        Money discountPrice = applyDiscount(orders);
        displayMoney(KoreaMoney.add(giftPrice, discountPrice), OUTPUT_TOTAL_PROFIT_MESSAGE);

        Money discountedPrice = getDiscountedPrice(originPrice, discountPrice);
        displayMoney(discountedPrice, OUTPUT_TOTAL_PRICE_MESSAGE);

        Grade grade = getGrade(KoreaMoney.add(giftPrice, discountPrice));
        displayGrade(grade);
    }

    private void createDate() {
        inputView.tryInput(() -> {
            int date = inputView.readDate();
            orderMaker.selectDate(date);
        });
    }

    private void createMenu() {
        inputView.tryInput(() -> {
            List<String> orders = Arrays.asList(inputView.readMenu());
            orderMaker.selectMenu(orders);
        });
    }

    private List<FoodItem> receiveGift(Orders orders) {
        return priceCalculator.receiveGifts(orders);
    }

    private Money getOriginPrice(Orders orders) {
        return KoreaMoney.from(
                priceCalculator.calculateOriginalPrice(orders)
        );
    }

    private Money getDiscountedPrice(Money originPrice, Money discountPrice) {
        return KoreaMoney.sub(originPrice, discountPrice);
    }

    private Money applyGift(List<FoodItem> gifts) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalGifts(gifts)
        );
    }

    private Money applyDiscount(Orders orders) {
        return KoreaMoney.from(
                priceCalculator.calculateTotalDiscount(orders)
        );
    }

    private Grade getGrade(Money discountPrice) {
        return Grade.createFrom(discountPrice);
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
