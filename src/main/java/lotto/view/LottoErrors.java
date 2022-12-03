package lotto.view;

import lotto.service.LottoSetting;

public enum LottoErrors {

    ERROR_HEAD("[ERROR] "),
    ERROR_NON_DIGIT(" 입력값은 반드시 숫자여야 합니다."),
    ERROR_NON_DIVIDABLE(String.format(" 금액은 %s원 단위로 입력해야 합니다.", LottoSetting.MONEY_UNIT.getAttribute())),
    ERROR_NUMBER_AMOUNT(String.format(" 당첨 번호는 반드시 %s개의 번호를 쉼표로 구분해서 입력헤야 합니다.",
            LottoSetting.NUMBER_AMOUNT.getAttribute())),
    ERROR_NUMBER_RANGE(" 당첨 번호는 반드시 %s 와 %s 사이의 숫자여야 합니다.");


    private final String Error;

    LottoErrors(String error) {
        Error = error;
    }

    public String getError() {
        return LottoErrors.valueOf("ERROR_HEAD") + Error;
    }
}
