package lotto.view;

public enum LottoMessage {

    START_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_MESSAGE("%s개를 구매하였습니다."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
