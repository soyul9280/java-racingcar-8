package racingcar.message;

public enum ErrorMessage {

    INVALID_NAME_BLANK("이름에 공백이 올 수 없습니다."),
    INVALID_NAME_NULL("이름에 null이 올 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
