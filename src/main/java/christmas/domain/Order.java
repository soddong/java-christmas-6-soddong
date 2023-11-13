package christmas.domain;

public class Order {
    private FoodName name;
    private Quantity count;

    private Order(FoodName name, Quantity count) {
        this.name = name;
        this.count = count;
    }

    public static Order of(FoodName name, Quantity count) {
        validate(name);
        return new Order(
                name,
                count
        );
    }

    private static void validate(FoodName name) {
        try {
            Menu.valueOf(name.getName());
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
}
