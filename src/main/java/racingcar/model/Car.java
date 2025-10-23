package racingcar.model;

public class Car {
    private final CarName name;
    public Car(CarName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                '}';
    }
}
