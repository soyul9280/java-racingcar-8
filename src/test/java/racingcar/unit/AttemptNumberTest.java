package racingcar.unit;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

public class AttemptNumberTest {

    @Test
    @DisplayName("예외: 시도 횟수가 0인 경우")
    void InvalidAttemptNumber_Zero_Fail() {
        assertThatThrownBy(() -> new AttemptNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_ZERO);
    }

    @Test
    @DisplayName("예외: 시도 횟수가 null인 경우")
    void InvalidAttemptNumber_Null_Fail() {
        assertThatThrownBy(()-> new AttemptNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_NULL);
    }

    @ParameterizedTest(name = "[case: {index}]")
    @ValueSource(strings = {""," "})
    @DisplayName("예외: 시도 횟수가 빈 문자열 혹은 공백인 경우")
    void InvalidAttemptNumber_Blank_Fail(String name) {
        assertThatThrownBy(()-> new AttemptNumber(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_BLANK);
    }

    @Test
    @DisplayName("예외: 시도 횟수가 0 미만인 경우")
    void InvalidAttemptNumber_Minus_Fail() {
        assertThatThrownBy(()-> new AttemptNumber(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_NUMBER_MINUS);
    }

}
