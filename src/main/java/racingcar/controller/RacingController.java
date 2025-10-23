package racingcar.controller;

import racingcar.model.AttemptNumber;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingController {
    public RacingController() {
    }

    public String gameStart() {
        Cars cars = Cars.createCarList(InputView.name());
        AttemptNumber attemptNumber = AttemptNumber.create(InputView.attemptNumber());

        return null;
    }
}
