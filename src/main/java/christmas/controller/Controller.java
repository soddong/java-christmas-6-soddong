package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.price.PriceCalculator;
import christmas.service.OrderMaker;
import christmas.view.InputView;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OrderMaker orderMaker;
    private final PriceCalculator priceCalculator;

    public Controller(InputView inputView, OrderMaker orderMaker,
                      PriceCalculator priceCalculator) {
        this.inputView = inputView;
        this.orderMaker = orderMaker;
        this.priceCalculator = priceCalculator;
    }

    public void start() {
        // 주문 받기
        createDate();
        createMenu();
        Orders orders = orderMaker.build();

        // 금액 계산

        // 할인 적용

        //


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


}
