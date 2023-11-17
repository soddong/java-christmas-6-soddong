package christmas.domain.order;

import christmas.dto.FoodItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<FoodItem> orders;
    private LocalDate date;

    private Orders(List<FoodItem> orders, LocalDate date) {
        this.orders = orders;
        this.date = date;
    }

    public static Orders createOf(List<FoodItem> orders, LocalDate date) {
        return new Orders(orders, date);
    }

    public List<FoodItem> getOrders() {
        return new ArrayList<>(orders);
    }

    public LocalDate getDate() {
        return date;
    }
}
