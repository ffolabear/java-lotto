package lotto.view;

public enum LottoMessage {

    START_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_MESSAGE("\n%s개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    RESULT_MESSAGE_HEADER("당첨 통계"),
    RESULT_MESSAGE_BORDER("---");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
