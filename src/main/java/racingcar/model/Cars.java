package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Utils;

public record Cars(List<Car> carList) {
    public static Cars createCarList(String input) {
        List<Car> carList = Utils.splitByComma(input).stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    public void commandMoveForward() {
        for (Car car : carList) {
            int randomNumber = pickRandomNumber();
            car.moveForward(randomNumber);
        }
    }

    public List<String> findWinnerList() {
        Integer winnerPosition = findWinnerPosition();
        return carList.stream()
                .filter(car -> car.comparesPosition(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private Integer findWinnerPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
