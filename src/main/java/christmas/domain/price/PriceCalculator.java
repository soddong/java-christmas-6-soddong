package christmas.domain.price;

import christmas.domain.food.Menu;
import christmas.dto.Item;
import java.util.List;

public class PriceCalculator {
    public int calculateItemsPrice(List<Item> items) {
        return items.stream()
                .mapToInt(item -> Menu.from(item.getName()).getPrice() * item.getQuantity())
                .sum();
    }
}
