package christmas.domain.price;

import christmas.domain.food.Menu;
import christmas.dto.ItemDto;
import java.util.List;

public class PriceCalculator {
    public int calculateItemsPrice(final List<ItemDto> itemDtos) {
        return itemDtos.stream()
                .mapToInt(item -> Menu.from(item.getName()).getPrice() * item.getQuantity())
                .sum();
    }
}
