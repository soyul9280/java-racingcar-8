package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.message.ErrorMessage;

public final class Utils {
    static Pattern splitComma=Pattern.compile(",");
    static Pattern comma = Pattern.compile("^[,]*$");

    private Utils() {
    }

    public static List<String> splitByComma(String input) {
        validateNames(input);
        return Arrays.asList(input.split(splitComma.pattern()));
    }

    public static int changeToInt(String input) {
        validateAttemptNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNames(String input) {
        if(input==null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NULL.message());
        }
        if(input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_BLANK.message());
        }
        if(comma.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NO_NAME.message());
        }
        if(input.startsWith(splitComma.pattern())||input.endsWith(splitComma.pattern())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LOCATION_COMMA.message());
        }
    }

    private static void validateAttemptNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_NUMBER_NULL.message());
        }
        if(input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_BLANK.message());
        }
    }
}

