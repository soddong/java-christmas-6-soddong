package christmas.domain.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeTest {

    @ParameterizedTest
    @CsvSource(value = {"5000,별", "10000,트리", "20000,산타", "0,없음", "7000, 별"}, delimiterString = ",")
    void getGradeByPrice(int price, Grade expected) {
        assertThat(Grade.createFrom(price))
                .isEqualTo(expected);
    }
}