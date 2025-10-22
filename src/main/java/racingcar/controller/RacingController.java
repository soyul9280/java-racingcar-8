package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
    }

    public String gameStart() {
        String name = InputView.name();
        int attemptNumber = Integer.parseInt(InputView.attemptNumber());

    }
}
