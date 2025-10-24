package racingcar.model;

public class Car {
    private static final int START_POSITION=0;
    private static final String MARK = "-";

    private final CarName name;
    private final Position position;
    public Car(CarName name) {
        this.name = name;
        this.position=new Position(START_POSITION);
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            position.increment();
        }
    }

    public boolean comparesPosition(int checkNumber) {
        return position.getPosition() == checkNumber;
    }

    public int getPosition() {
        return position.getPosition();
    }
    public String getName() {
        return name.getCarName();
    }

    @Override
    public String toString() {
        return name.getCarName() + " : " + MARK.repeat(position.getPosition());
    }
}
