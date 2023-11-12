package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<OrderFood> orders;
    private static final int MAX_ORDER_SIZE = 20;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrderFood(OrderFood orderFood) {
        if (isOrderSizeExceeded(orderFood)) {
            throw new IllegalArgumentException();
        }
        if (isDrinkOnlyOrder(orderFood)) {
            throw new IllegalArgumentException();
        }
        this.orders.add(orderFood);
    }

    private boolean isOrderSizeExceeded(OrderFood newOrderFood) {
        int totalSize = orders.stream()
                .mapToInt(OrderFood::getQuantity)
                .sum() + newOrderFood.getQuantity();
        return totalSize > MAX_ORDER_SIZE;
    }

    private boolean isDrinkOnlyOrder(OrderFood newOrderFood) {
        if (newOrderFood.menu().getCategory() != FoodCategory.DRINK) {
            return false;
        }

        return orders.stream()
                .allMatch(orderFood -> orderFood.menu().getCategory() == FoodCategory.DRINK);
    }

    public List<OrderFood> getOrderFoods() {
        return new ArrayList<>(orders);
    }

    // TODO; INPUT 예외처리 ('-'없음, 빈값)
}
