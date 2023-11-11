package christmas.domain;

public class FoodName {
    private String name;

    private FoodName(String name) {
        this.name = name;
    }

    public static FoodName from(final String name) {
        validate(name);
        return new FoodName(name);
    }

    public static void validate(final String name) {
        // 빈 경우
        if (name.isBlank())
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
