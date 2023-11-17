package christmas.domain.price;

import christmas.domain.food.Menu;
import christmas.dto.FoodItem;
import java.util.List;

public class PriceCalculator {
    public int calculateItemsPrice(List<FoodItem> items) {
        return items.stream()
                .mapToInt(item -> Menu.from(item.getName()).getPrice() * item.getQuantity())
                .sum();
    }
}
