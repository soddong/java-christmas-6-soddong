package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputNumber {
    public static int inputDateNumber() {
        String input = Console.readLine();
        InputValidator.validateInputDateNumber(input);
        return Integer.parseInt(input);
    }

    public static String[] inputMenuString() {
        String input = Console.readLine();
        InputValidator.validateInputOrderString(input);
        return input.split(",");
    }

}
