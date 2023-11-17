package christmas.view;

import static christmas.view.OutputPrinter.OUTPUT_GIFT_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_ORDER_MESSAGE;
import static christmas.view.OutputPrinter.newLine;
import static christmas.view.OutputPrinter.printMessage;

import christmas.domain.event.Grade;
import christmas.domain.price.money.Money;
import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.util.List;

public class OutputManager {
    public static void displayGrade(final Grade grade) {
        newLine();
        printMessage(OutputPrinter.OUTPUT_EVENT_BEDGE_MESSAGE);
        printMessage(grade.name());
    }

    public static void displayGifts(final List<Item> gifts) {
        newLine();
        printMessage(OUTPUT_GIFT_MESSAGE);
        if (gifts.isEmpty()) {
            printMessage("없음");
        }
        for (Item item : gifts) {
            printMessage(item.toString());
        }
    }

    public static void displayOrder(final OrdersDto ordersDto) {
        newLine();
        printMessage(OUTPUT_ORDER_MESSAGE);
        for (Item item : ordersDto.getOrders()) {
            printMessage(item.toString());
        }
    }

    public static void displayMoney(final Money price, final String message) {
        newLine();
        printMessage(message);
        printMessage(price.toString());
    }
}
