package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
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

    public void moveForward(){
        if(isPossible()){
            position++;
        }
    }

    private boolean isPossible() {
        return Randoms.pickNumberInRange(0,9) >=4;
    }
}
