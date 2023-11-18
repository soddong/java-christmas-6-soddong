package christmas.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutputPrinter {
    public static final String OUTPUT_INTRO_MESSAGE = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String OUTPUT_ORDER_MESSAGE = "<주문 메뉴>";
    public static final String OUTPUT_ORIGIN_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    public static final String OUTPUT_GIFT_MESSAGE = "<증정 메뉴>";
    public static final String OUTPUT_DETAIL_PROFIT_MESSAGE = "<혜택 내역>";
    public static final String OUTPUT_TOTAL_PROFIT_MESSAGE = "<총혜택 금액>";
    public static final String OUTPUT_EVENT_BEDGE_MESSAGE = "<12월 이벤트 배지>";
    public static final String OUTPUT_TOTAL_PRICE_MESSAGE = "<할인 후 예상 결제 금액>";

    public static String introFormat(LocalDate date) {
        return String.format("%s%s",
                date.format(DateTimeFormatter.ofPattern("MM월 dd일")), OUTPUT_INTRO_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
