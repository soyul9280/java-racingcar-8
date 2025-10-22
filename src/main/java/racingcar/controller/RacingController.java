package racingcar.controller;

import racingcar.message.ErrorMessage;
import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
    }

    public String gameStart() {
        String name = InputView.name();

        if(name ==null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NULL.message());
        }
        if(name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_BLANK.message());
        }
        if (name.length() < 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LONG.message());
        }

        return null;
    }
}
