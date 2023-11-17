package christmas.domain.price;

import christmas.domain.food.FoodItem;
import java.util.List;

//TODO 역할 분리
public class PriceCalculator {
    public int calculateItemsPrice(List<FoodItem> items) {
        return items.stream()
                .mapToInt(item -> item.menu().getPrice() * item.getQuantity())
                .sum();
    }

    public int calculateTotalGifts(List<FoodItem> items) {
        return items.stream()
                .mapToInt(item -> item.menu().getPrice() * item.getQuantity())
                .sum();
    }

}
