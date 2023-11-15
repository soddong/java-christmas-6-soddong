package christmas.view;

public class OutputView {

    public static final String OUTPUT_ORDER_MESSAGE = "<주문 메뉴>";
    public static final String OUTPUT_ORIGIN_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    public static final String OUTPUT_GIFT_MESSAGE = "<증정 메뉴>";
    public static final String OUTPUT_TOTAL_PROFIT_MESSAGE = "<총혜택 금액>";
    public static final String OUTPUT_EVENT_BEDGE_MESSAGE = "<12월 이벤트 배지>";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
