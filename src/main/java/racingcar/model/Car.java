package racingcar.model;

public class Car {
    private static final int START_POSITION=0;

    private final CarName name;
    private final Position position;
    public Car(CarName name) {
        this.name = name;
        this.position=new Position(START_POSITION);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                '}';
    }
}
