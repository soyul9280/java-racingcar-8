package racingcar.model;

import java.util.regex.Pattern;
import racingcar.message.ErrorMessage;

public class CarName {
    private final String carName;
    Pattern regex = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]*$");

    public CarName(String splitName) {
        validateSplitName(splitName);
        this.carName = splitName;
    }

    private void validateSplitName(String splitName) {
        if(splitName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_SEQUENCE_COMMA.message());
        }
        if(!regex.matcher(splitName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_SPECIAL_CHARACTERS.message());
        }
        if (splitName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LONG.message());
        }
    }

    @Override
    public String toString() {
        return "CarName{" +
                "carName='" + carName + '\'' +
                '}';
    }
}
