package christmas.domain.price;

import christmas.domain.food.Menu;
import christmas.dto.ItemDto;
import java.util.List;

public class PriceCalculator {
    public static int calculateItemsPrice(final List<ItemDto> itemDtos) {
        return itemDtos.stream()
                .mapToInt(PriceCalculator::calculateItemPrice)
                .sum();
    }

    public static int calculateItemPrice(final ItemDto item) {
        return Menu.from(item.getName()).getPrice() * item.getQuantity();
    }
}
