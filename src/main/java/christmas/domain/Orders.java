package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders;
    private static final int MAX_ORDER_SIZE = 20;

    public Orders() {
        this.orders = new ArrayList<>();
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

    // TODO; INPUT 예외처리 ('-'없음, 빈값)
}
