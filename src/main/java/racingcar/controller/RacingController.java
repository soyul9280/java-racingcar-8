package racingcar.controller;

import java.util.regex.Pattern;
import racingcar.message.ErrorMessage;
import racingcar.view.InputView;

public class RacingController {
    Pattern splitComma=Pattern.compile(",");
    Pattern regex = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]*$");
    Pattern comma = Pattern.compile("^[,]*$");

    public RacingController() {
    }

    public String gameStart() {
        String name = InputView.name();

        if(name ==null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NULL.message());
        }
        if(name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_BLANK.message());
        }
        if(comma.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NO_NAME.message());
        }
        if(name.startsWith(splitComma.pattern())||name.endsWith(splitComma.pattern())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LOCATION_COMMA.message());
        }

        String[] splitNames = name.split(splitComma.pattern());
        for (String splitName : splitNames) {
            if(!regex.matcher(splitName).matches()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_SPECIAL_CHARACTERS.message());
            }
            if (splitName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LONG.message());
            }
        }
        return null;
    }
}
