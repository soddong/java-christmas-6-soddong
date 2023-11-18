package christmas.view;

import static christmas.view.OutputPrinter.OUTPUT_DETAIL_PROFIT_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_GIFT_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_ORDER_MESSAGE;
import static christmas.view.OutputPrinter.OUTPUT_TOTAL_PROFIT_MESSAGE;
import static christmas.view.OutputPrinter.introFormat;
import static christmas.view.OutputPrinter.newLine;
import static christmas.view.OutputPrinter.printMessage;

import christmas.domain.event.Grade;
import christmas.domain.price.money.Money;
import christmas.dto.ItemDto;
import christmas.dto.OrdersDto;
import java.time.LocalDate;
import java.util.List;

public class OutputManager {
    public static void displayGrade(final Grade grade) {
        newLine();
        printMessage(OutputPrinter.OUTPUT_EVENT_BEDGE_MESSAGE);
        printMessage(grade.name());
    }

    public static void displayGifts(final List<ItemDto> gifts) {
        newLine();
        printMessage(OUTPUT_GIFT_MESSAGE);
        if (gifts.isEmpty()) {
            printMessage("없음");
        }
        for (ItemDto itemDto : gifts) {
            printMessage(itemDto.toString());
        }
    }

    public static void displayOrder(final OrdersDto ordersDto) {
        newLine();
        printMessage(OUTPUT_ORDER_MESSAGE);
        for (ItemDto itemDto : ordersDto.orders()) {
            printMessage(itemDto.toString());
        }
    }

    public static void displayProfit(final Money price) {
        newLine();
        printMessage(OUTPUT_TOTAL_PROFIT_MESSAGE);
        printMessage(String.format("-%s", price.toString()));
    }

    public static void displayPrice(final Money price, final String message) {
        newLine();
        printMessage(message);
        printMessage(String.format("%s", price.toString()));
    }

    public static void displayDetailProfits(List<String> detailProfits) {
        newLine();
        printMessage(OUTPUT_DETAIL_PROFIT_MESSAGE);
        for (String profit : detailProfits) {
            printMessage(profit);
        }
    }

    public static void displayDate(LocalDate date) {
        printMessage(introFormat(date));
    }
}
