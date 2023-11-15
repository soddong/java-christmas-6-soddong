package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static final int MAX_ORDER_SIZE = 20;

    private List<FoodItem> orders;
    private LocalDate date;

    public Orders() {
        this.orders = new ArrayList<>();
        this.date = LocalDate.of(2023, 1, 8);
    }

    public Orders(LocalDate date) {
        this.orders = new ArrayList<>();
        this.date = date;
    }

    public Orders(List<FoodItem> orders, LocalDate date) {
        this.orders = orders;
        this.date = date;
    }

    public void addOrder(FoodItem order) {
        if (isOrderSizeExceeded(order)) {
            throw new IllegalArgumentException("주문개수를 초과");
        }
        if (isDrinkOnlyOrder(order)) {
            throw new IllegalArgumentException("음료만 주문 안됨");
        }
        this.orders.add(order);
    }

    private boolean isOrderSizeExceeded(FoodItem newOrder) {
        int totalSize = orders.stream()
                .mapToInt(FoodItem::getQuantity)
                .sum() + newOrder.getQuantity();
        return totalSize > MAX_ORDER_SIZE;
    }

    private boolean isDrinkOnlyOrder(FoodItem newOrder) {
        if (newOrder.menu().getCategory() != FoodCategory.DRINK) {
            return false;
        }

        return orders.stream()
                .allMatch(orderFood -> orderFood.menu().getCategory() == FoodCategory.DRINK);
    }

    public List<FoodItem> getOrders() {
        return new ArrayList<>(orders);
    }

    public LocalDate getDate() {
        return date;
    }

    // TODO; INPUT 예외처리 ('-'없음, 빈값)
}
