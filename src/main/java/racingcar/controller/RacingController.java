package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingController {
    public RacingController() {
    }

    public String gameStart() {
        Cars cars = Cars.createCarList(InputView.name());

        return null;
    }
}
