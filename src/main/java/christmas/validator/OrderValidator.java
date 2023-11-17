package christmas.validator;

import christmas.domain.food.FoodCategory;
import christmas.domain.food.Menu;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO: 역할분리
public class OrderValidator {
    private static final int MAX_ORDER_SIZE = 20;
    private final static String ORDER = "주문";

    public static void validateOrders(List<String> orders) {
        validateSize(orders.size());
        validateDuplicatedOrder(orders);
        validateDrinkOnlyOrder(orders);
    }

    private static void validateSize(final int size) {
        if (size > MAX_ORDER_SIZE) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }

    private static void validateDuplicatedOrder(List<String> orders) {
        Set<String> uniqueNames = new HashSet<>(orders);
        if (uniqueNames.size() != orders.size()) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }

    private static void validateDrinkOnlyOrder(final List<String> orders) {
        if (orders.stream()
                .allMatch(orderFood -> Menu.valueOf(orderFood).getCategory() == FoodCategory.DRINK)) {
            throw ExceptionMessage.INVALID_VALUE.create(ORDER);
        }
    }
}
