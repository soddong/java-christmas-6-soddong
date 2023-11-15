package christmas.view;

import java.util.function.Function;
import java.util.function.Supplier;

public class InputView {
    private final static String INPUT_INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? " +
                                                        "(숫자만 입력해 주세요!)";
    private final static String INPUT_MENU_QUANTITY_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. " +
                                                                "(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public InputView() {
        System.out.println(INPUT_INTRO_MESSAGE);
    }

    public void tryInput(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            tryInput(action);
        }
    }

    public int readDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        return InputNumber.inputDateNumber();
    }

    public String[] readMenu() {
        System.out.println(INPUT_MENU_QUANTITY_MESSAGE);
        return InputNumber.inputMenuString();
    }

}
