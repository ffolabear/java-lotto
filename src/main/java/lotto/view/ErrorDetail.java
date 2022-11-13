package lotto.view;

public enum ErrorDetail {

    ERROR_HEAD("[ERROR] "),
    ERROR_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NON_DIVIDABLE("1,000원 단위로 입력해 주세요."),
    ERROR_ILLEGAL_INPUT("입력값은 반드시 숫자여야 합니다."),
    ERROR_NUMBER_AMOUNT("당첨 번호는 반드시 여섯 개여야 합니다."),
    ERROR_NUMBER_COMMA("숫자와 숫자 사이에 쉼표를 넣어 주세요."),
    ERROR_NON_INTEGER("1인당 구매할 수 있는 최대 로또 개수는 214만 장입니다."),
    ERROR_DUPLICATE_NUMBER("당첨 번호는 중복되지 않는 번호여야 합니다."),
    ERROR_DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않는 번호여야 합니다.")
    ;

    private final String error;

    ErrorDetail(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
