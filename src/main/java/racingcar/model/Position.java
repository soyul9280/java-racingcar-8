package racingcar.model;

import racingcar.message.ErrorMessage;

public class Position {
    private int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION_MINUS.message());
        }
    }

    public int getPosition() {
        return position;
    }

    public void increment(){
        position++;
    }

}
