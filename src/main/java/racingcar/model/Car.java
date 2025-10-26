package racingcar.model;

public class Car {
    private static final int START_POSITION=0;
    private static final String MARK = "-";
    private static final int SPEED = 1;
    private static final int RANDOM_BOUNDARY = 4;


    private final CarName name;
    private final Position position;
    private final int speed;

    public Car(CarName name) {
        this.name = name;
        this.position=new Position(START_POSITION);
        this.speed=SPEED;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber>=RANDOM_BOUNDARY) {
            position.increment(speed);
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
