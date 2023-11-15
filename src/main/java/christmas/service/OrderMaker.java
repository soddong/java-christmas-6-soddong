package christmas.service;

import christmas.domain.FoodItem;
import christmas.domain.FoodName;
import christmas.domain.Orders;
import christmas.domain.Quantity;
import christmas.domain.calendar.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderMaker {
    private LocalDate date;
    private List<FoodItem> menus;


    public OrderMaker selectDate(int day) {
        this.date = LocalDate.of(2023, 12, day);
        return this;
    }

    public OrderMaker selectMenu(List<String> menus) {
        this.menus = new ArrayList<>();
        for (String menu : menus) {
            String[] items = menu.split("-");
            this.menus.add(new FoodItem(
                    FoodName.from(items[0]),
                    Quantity.from(items[1])
            ));
        }
        return this;
    }

    public Orders build() {
        return new Orders(menus, date);
    }
}
