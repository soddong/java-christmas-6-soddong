package christmas.domain.food;

import static christmas.domain.food.FoodCategory.APPETIZER;
import static christmas.domain.food.FoodCategory.DESSERT;
import static christmas.domain.food.FoodCategory.DRINK;
import static christmas.domain.food.FoodCategory.MAINDISH;

public enum Menu {
    양송이스프(APPETIZER, 6_000),
    타파스(APPETIZER, 5_500),
    시저샐러드(APPETIZER, 8_000),
    티본스테이크(MAINDISH, 55_000),
    바비큐립(MAINDISH, 54_000),
    해산물파스타(MAINDISH, 35_000),
    크리스마스파스타(MAINDISH, 25_000),
    초코케이크(DESSERT, 15_000),
    아이스크림(DESSERT, 5_000),
    제로콜라(DRINK, 3_000),
    레드와인(DRINK, 60_000),
    샴페인(DRINK, 25_000);

    private final FoodCategory category;
    private final int price;

    Menu(FoodCategory category, int price) {
        this.category = category;
        this.price = price;
    }

    public static Menu from(final FoodName name) {
        return Menu.valueOf(name.getName());
    }

    public FoodCategory getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}