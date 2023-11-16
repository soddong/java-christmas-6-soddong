package christmas.controller;

import christmas.domain.order.OrderMaker;
import christmas.domain.order.Orders;
import christmas.view.InputView;
import java.util.Arrays;
import java.util.List;

public class OrderController {
    private final InputView inputView;
    private final OrderMaker orderMaker;

    public OrderController(InputView inputView, OrderMaker orderMaker) {
        this.inputView = inputView;
        this.orderMaker = orderMaker;
    }

    public Orders createOrder() {
        createDate();
        createMenu();
        return orderMaker.build();
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

