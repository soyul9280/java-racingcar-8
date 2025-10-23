package racingcar.controller;

import java.util.regex.Pattern;
import racingcar.message.ErrorMessage;
import racingcar.view.InputView;

public class RacingController {
    Pattern comma=Pattern.compile(",");
    Pattern regex = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]*$");

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
        if(name.startsWith(comma.pattern())||name.endsWith(comma.pattern())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LOCATION_COMMA.message());
        }

        String[] splitNames = name.split(comma.pattern());
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
