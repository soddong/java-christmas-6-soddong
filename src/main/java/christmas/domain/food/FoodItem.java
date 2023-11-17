package christmas.domain.food;

public class FoodItem {
    private FoodName name;
    private Quantity count;

    public FoodItem(FoodName name, Quantity count) {
        this.name = name;
        this.count = count;
    }

    public static FoodItem createItem(String name, String count) {
        validate(name);
        return new FoodItem(
                FoodName.from(name),
                Quantity.from(count)
        );
    }

    private static void validate(String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public Menu menu() {
        return Menu.valueOf(name.getName());
    }

    public int getQuantity() {
        return count.getQuantity();
    }

    public String toString() {
        return String.format("%s %d개", name.getName(), count.getQuantity());
    }
}
