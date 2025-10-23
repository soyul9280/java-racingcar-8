package racingcar.model;

import racingcar.message.ErrorMessage;

public record AttemptNumber(int attemptNumber) {

    public AttemptNumber {
        validate(attemptNumber);
    }

    private void validate(int input) {
        if (attemptNumber == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_NUMBER_ZERO.message());
        }
        if (input < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_NUMBER_MINUS.message());
        }
    }
}
