package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderFoods {
    private Map<FoodMenu, Integer> foods = new HashMap<>();

    public void saveOrderMenu(final FoodMenu menu, final int count) {
        foods.put(menu, count);
    }

    public int findCountOfMenu(final String menu) {
        return foods.getOrDefault(menu, 0);
    }
}
