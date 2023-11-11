package christmas.domain;

// dto
public class OrderFood {
    private FoodName name;
    private Quantity count;

    private OrderFood(FoodName name, Quantity count) {
        this.name = name;
        this.count = count;
    }

    public static OrderFood of(FoodName name, Quantity count) {
        validate(name);
        return new OrderFood(
                name,
                count
        );
    }

    private static void validate(FoodName name) {
        // 메뉴판에 없는 경우
        try {
            Menu.valueOf(name.getName());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public Menu menu() {
        return Menu.valueOf(name.getName());
    }

    public Quantity count() {
        return count;
    }
}
