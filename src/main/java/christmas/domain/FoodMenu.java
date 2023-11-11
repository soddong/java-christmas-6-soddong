package christmas.domain;

import static christmas.domain.FoodCategory.APPETIZER;
import static christmas.domain.FoodCategory.DESSERT;
import static christmas.domain.FoodCategory.DRINK;
import static christmas.domain.FoodCategory.MAINDISH;

public enum FoodMenu {
    MUSHROOM_SOUP(APPETIZER, Money.from(6_000)),
    TAPAS(APPETIZER, Money.from(5_500)),
    CAESAR_SALAD(APPETIZER, Money.from(8_000)),
    T_BONE_STEAK(MAINDISH, Money.from(55_000)),
    BBQ_RIBS(MAINDISH, Money.from(54_000)),
    SEAFOOD_PASTA(MAINDISH, Money.from(35_000)),
    CHRISTMAS_PASTA(MAINDISH, Money.from(25_000)),
    CHOCO_CAKE(DESSERT, Money.from(15_000)),
    ICECREAM(DESSERT, Money.from(5_000)),
    ZERO_COKE(DRINK, Money.from(3_000)),
    RED_WINE(DRINK, Money.from(60_000)),
    CHAMPAGNE(DRINK, Money.from(25_000));

    private final FoodCategory category;
    private final Money price;

    private FoodMenu(FoodCategory category, Money price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category.name();
    }

    public int getPrice() {
        return price.money();
    }
}