package racingcar.message;

public enum ErrorMessage {

    INVALID_NAME_BLANK("이름에 공백이 올 수 없습니다."),
    INVALID_NAME_NULL("이름에 null이 올 수 없습니다."),
    INVALID_NAME_LONG("이름은 5자를 초과할 수 없습니다."),
    INVALID_NAME_LOCATION_COMMA("이름에 시작과 끝에 , 가 올 수 없습니다."),
    INVALID_NAME_SPECIAL_CHARACTERS("이름에 , 를 제외한 특수 문자는 올 수 없습니다."),
    INVALID_NAME_NO_NAME("이름에 , 만 존재합니다. 이름을 적어주세요."),
    INVALID_NAME_SEQUENCE_COMMA("이름에 ,를 연속으로 사용할 수 없습니다."),

    INVALID_ATTEMPT_NUMBER_BLANK("시도 횟수에 null이 올 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
