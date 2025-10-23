package racingcar.model;

import java.util.List;
import racingcar.Utils;

//원시값 풀어주는
public record Cars(List<Car> carList) {
    public static Cars createCarList(String input) {
        List<Car> carList = Utils.splitByComma(input).stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carList=" + carList +
                '}';
    }
}
