package christmas.dto;

import christmas.domain.food.FoodName;
import christmas.domain.food.Quantity;

public class Item {
    private FoodName name;
    private Quantity count;

    public Item(FoodName name, Quantity count) {
        this.name = name;
        this.count = count;
    }

    public static Item createItem(String name, String count) {
        return new Item(
                FoodName.from(name),
                Quantity.from(count)
        );
    }

    public FoodName getName() {
        return name;
    }

    public int getQuantity() {
        return count.getQuantity();
    }

    public String toString() {
        return String.format("%s %d개", name.getName(), count.getQuantity());
    }
}
