package christmas.domain;

import static christmas.domain.FoodCategory.APPETIZER;
import static christmas.domain.FoodCategory.DESSERT;
import static christmas.domain.FoodCategory.DRINK;
import static christmas.domain.FoodCategory.MAINDISH;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderFoods {
    private final int MAX_ORDER_SIZE = 20;
    private Map<FoodCategory, Map<Menu, Quantity>> foods = new EnumMap<>(FoodCategory.class);

    // TODO: 덮어쓰는 방식이 아닌 합치는 방식
    public void saveOrderMenus(List<OrderFood> orders) {
        validate(orders);
        orders.stream()
                .forEach(order -> saveEachOrder(order.menu(), order.count()));
    }

    private void saveEachOrder(final Menu menu, final Quantity count) {
        foods.put(menu.getCategory(),
                Map.of(menu, count));
    }

    public boolean hasCategory(final FoodCategory category) {
        return foods.containsKey(category);
    }

    private void validate(List<OrderFood> orders) {
        // 개수 검증
        boolean isOverRange = orders.stream()
                .map(OrderFood::count)
                .reduce(new Quantity(0), Quantity::add).isOver(MAX_ORDER_SIZE);

        if (isOverRange)
            throw new IllegalArgumentException();

        // TODO: 효율적으로 바꾸는 법 고민
        // 음료만 있으면 제한
        if (hasCategory(DRINK) &&
                hasCategory(APPETIZER) &&
                hasCategory(DESSERT) &&
                hasCategory(MAINDISH)
        ) throw new IllegalArgumentException();
    }


    // TODO; INPUT 예외처리 ('-'없음, 빈값)
}
