package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static final int MAX_ORDER_SIZE = 20;

    private List<Order> orders;
    private LocalDate date;

    public Orders(LocalDate date) {
        this.orders = new ArrayList<>();
        this.date = date;
    }

    public void addOrder(Order order) {
        if (isOrderSizeExceeded(order)) {
            throw new IllegalArgumentException();
        }
        if (isDrinkOnlyOrder(order)) {
            throw new IllegalArgumentException();
        }
        this.orders.add(order);
    }

    private boolean isOrderSizeExceeded(Order newOrder) {
        int totalSize = orders.stream()
                .mapToInt(Order::getQuantity)
                .sum() + newOrder.getQuantity();
        return totalSize > MAX_ORDER_SIZE;
    }

    private boolean isDrinkOnlyOrder(Order newOrder) {
        if (newOrder.menu().getCategory() != FoodCategory.DRINK) {
            return false;
        }

        return orders.stream()
                .allMatch(orderFood -> orderFood.menu().getCategory() == FoodCategory.DRINK);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public LocalDate getDate() {
        return date;
    }

    // TODO; INPUT 예외처리 ('-'없음, 빈값)
}
