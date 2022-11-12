package lotto.util;

public enum MessageDetail {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_TITLE("당첨 통계\n"),
    RESULT_TITLE_LINE("---\n")
    ;

    private final String message;

    MessageDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
