package racingcar.model;

import racingcar.Utils;
import racingcar.message.ErrorMessage;

public record AttemptNumber(int count) {
    public static AttemptNumber create(String input) {
        int changedNumber = Utils.changeToInt(input);
        validate(changedNumber);
        return new AttemptNumber(changedNumber);
    }

    private static void validate(int changedNumber) {
        if (changedNumber == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_NUMBER_ZERO.message());
        }
        if (changedNumber < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_NUMBER_MINUS.message());
        }
    }
}
