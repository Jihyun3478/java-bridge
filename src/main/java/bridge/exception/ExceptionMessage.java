package bridge.exception;

public enum ExceptionMessage {
    NOT_NUMBER_FORMAT("숫자 형식이 아닙니다."),
    INVALID_INPUT_FORMAT("%s 또는 %s를 입력해야 합니다."),
    OUT_OF_RANGE("%,d ~ %,d 사이의 수를 입력해야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해 주세요.";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message + POSTFIX, args);
    }
}
