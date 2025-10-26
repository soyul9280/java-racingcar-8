package racingcar.unit;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;
import racingcar.model.AttemptNumber;

public class AttemptNumberTest {
    @Test
    @DisplayName("예외: 시도 횟수가 0인 경우")
    void InvalidAttemptNumber_Zero_Fail() {
        assertThatThrownBy(() -> AttemptNumber.create("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_ZERO.message());
    }

    @Test
    @DisplayName("예외: 시도 횟수가 null인 경우")
    void InvalidAttemptNumber_Null_Fail() {
        assertThatThrownBy(()-> AttemptNumber.create(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_NULL.message());
    }

    @ParameterizedTest(name = "[case: {index}]")
    @ValueSource(strings = {""," "})
    @DisplayName("예외: 시도 횟수가 빈 문자열 혹은 공백인 경우")
    void InvalidAttemptNumber_Blank_Fail(String name) {
        assertThatThrownBy(()-> AttemptNumber.create(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_BLANK.message());
    }

    @Test
    @DisplayName("예외: 시도 횟수가 0 미만인 경우")
    void InvalidAttemptNumber_Minus_Fail() {
        assertThatThrownBy(()-> AttemptNumber.create("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_MINUS.message());
    }

}
