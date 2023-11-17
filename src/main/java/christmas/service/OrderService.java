package christmas.service;

import christmas.domain.order.OrderMaker;
import christmas.domain.order.Orders;
import christmas.view.InputManager;
import java.util.Arrays;
import java.util.List;

public class OrderService {
    private final InputManager inputManager;
    private final OrderMaker orderMaker;

    public OrderService(InputManager inputManager, OrderMaker orderMaker) {
        this.inputManager = inputManager;
        this.orderMaker = orderMaker;
    }

    public Orders createOrder() {
        createDate();
        createMenu();
        return orderMaker.build();
    }

    private void createDate() {
        inputManager.tryInput(() -> {
            int date = inputManager.readDate();
            orderMaker.selectDate(date);
        });
    }

    private void createMenu() {
        inputManager.tryInput(() -> {
            List<String> orders = Arrays.asList(inputManager.readMenu());
            orderMaker.selectMenu(orders);
        });
    }
}

