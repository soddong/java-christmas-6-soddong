package christmas.service;

import christmas.domain.order.OrdersMaker;
import christmas.dto.OrdersDto;
import christmas.view.InputManager;
import java.util.Arrays;
import java.util.List;

public class OrderService {
    private final InputManager inputManager;
    private final OrdersMaker ordersMaker;

    public OrderService(InputManager inputManager, OrdersMaker ordersMaker) {
        this.inputManager = inputManager;
        this.ordersMaker = ordersMaker;
    }

    public OrdersDto createOrder() {
        createDate();
        createMenu();
        return ordersMaker.build();
    }

    private void createDate() {
        inputManager.tryInput(() -> {
            int date = inputManager.readDate();
            ordersMaker.selectDate(date);
        });
    }

    private void createMenu() {
        inputManager.tryInput(() -> {
            List<String> orders = Arrays.asList(inputManager.readMenu());
            this.ordersMaker.selectMenu(orders);
        });
    }
}

