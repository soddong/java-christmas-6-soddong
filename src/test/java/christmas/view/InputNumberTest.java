package christmas.view;

import christmas.validator.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    public void 날짜를_입력받아라(String input) {
        Assertions.assertDoesNotThrow(() -> InputValidator.validateInputDateNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "32", ""})
    public void 범위에서_벗어나거나_빈문자열이_입력되면_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateInputDateNumber(input))
                        .withMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1", "제로콜라-1,티본스테이크-3"})
    public void 메뉴를_입력받아라(String input) {
        Assertions.assertDoesNotThrow(() -> InputValidator.validateInputOrderString(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2,티본스테이크-1", ",티본스테이크-1", "티본스테이크-,제로콜라-1"})
    public void 메뉴의_포맷이_맞지않으면_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateInputOrderString(input))
                .withMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}