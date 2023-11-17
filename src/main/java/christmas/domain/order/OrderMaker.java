package christmas.domain.order;

import static christmas.validator.OrderValidator.validateOrders;

import christmas.domain.food.FoodName;
import christmas.domain.food.Quantity;
import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMaker {
    private LocalDate date;
    private List<Item> menus;

    public OrderMaker selectDate(int day) {
        this.date = LocalDate.of(2023, 12, day);
        return this;
    }

    public OrderMaker selectMenu(List<String> menus) {
        validateOrders(menus.stream()
                .map(menu -> menu.split("-")[0])
                .collect(Collectors.toList()));

        this.menus = new ArrayList<>();
        for (String menu : menus) {
            String[] items = menu.split("-");
            this.menus.add(new Item(
                    FoodName.from(items[0]),
                    Quantity.from(items[1])
            ));
        }
        return this;
    }

    public OrdersDto build() {
        return new OrdersDto(menus, date);
    }
}
