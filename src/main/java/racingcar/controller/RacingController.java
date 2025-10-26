package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptNumber;
import racingcar.model.Car;
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
        int attempt = attemptNumber.count();
        OutputView.guide();
        while (attempt > 0) {
            cars.commandMoveForward();
            OutputView.markingCar(cars);
            attempt--;
        }
    }

    private void gameEnd(Cars cars) {
        List<String> winnerNameList = cars.findWinnerList().stream()
                .map(Car::getName)
                .toList();
        OutputView.winner(winnerNameList);
    }
}
