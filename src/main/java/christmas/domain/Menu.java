package christmas.domain;

import static christmas.domain.FoodCategory.APPETIZER;
import static christmas.domain.FoodCategory.DESSERT;
import static christmas.domain.FoodCategory.DRINK;
import static christmas.domain.FoodCategory.MAINDISH;

public enum Menu {
    양송이스프(APPETIZER, Money.from(6_000)),
    타파스(APPETIZER, Money.from(5_500)),
    시저샐러드(APPETIZER, Money.from(8_000)),
    티본스테이크(MAINDISH, Money.from(55_000)),
    바비큐립(MAINDISH, Money.from(54_000)),
    해산물파스타(MAINDISH, Money.from(35_000)),
    크리스마스파스타(MAINDISH, Money.from(25_000)),
    초코케이크(DESSERT, Money.from(15_000)),
    아이스크림(DESSERT, Money.from(5_000)),
    제로콜라(DRINK, Money.from(3_000)),
    레드와인(DRINK, Money.from(60_000)),
    샴페인(DRINK, Money.from(25_000));

    private final FoodCategory category;
    private final Money price;

    private Menu(FoodCategory category, Money price) {
        this.category = category;
        this.price = price;
    }

    public static Menu from(FoodName name) {
        return Menu.valueOf(name.getName());
    }

    public FoodCategory getCategory() {
        return category;
    }
}