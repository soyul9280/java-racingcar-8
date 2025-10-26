package racingcar.model;

import java.util.regex.Pattern;
import racingcar.message.ErrorMessage;

public class CarName {
    private final String carName;
    Pattern specialCharacter = Pattern.compile("[^,a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]");

    public CarName(String splitName) {
        validateSplitName(splitName);
        this.carName = splitName;
    }

    private void validateSplitName(String splitName) {
        if(splitName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_SEQUENCE_COMMA.message());
        }
        if(splitName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_BLANK.message());
        }
        if(specialCharacter.matcher(splitName).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_SPECIAL_CHARACTERS.message());
        }
        if (splitName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LONG.message());
        }
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "carName='" + carName + '\'' +
                '}';
    }
}
