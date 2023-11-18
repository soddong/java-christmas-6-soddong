package christmas.validator;

public enum ExceptionMessage {
    INVALID_VALUE("[ERROR] 유효하지 않은 %s입니다. 다시 입력해 주세요.");

    private final String messageFormat;

    ExceptionMessage(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public IllegalArgumentException create(String item) {
        String formattedMessage = String.format(messageFormat, item);
        return new IllegalArgumentException(formattedMessage);
    }
}
