package racingcar.controller;

import racingcar.model.AttemptNumber;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public RacingController() {
    }

    public void gameStart() {
        Cars cars = Cars.createCarList(InputView.name());
        AttemptNumber attemptNumber = AttemptNumber.create(InputView.attemptNumber());
        gameProcess(cars, attemptNumber);
        gameEnd(cars);
    }

    private void gameProcess(Cars cars, AttemptNumber attemptNumber) {
        int attempt = attemptNumber.attemptNumber();
        while (attempt > 0) {
            cars.commandMoveForward();
            attempt--;
        }
    }

    private void gameEnd(Cars cars) {
        OutputView.markingCar(cars);
        OutputView.winner(cars.findWinnerList());
    }
}
