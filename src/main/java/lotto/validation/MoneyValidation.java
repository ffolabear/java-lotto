package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.*;

public class MoneyValidation implements Predicate {

    private final CommonValidation commonValidation = new CommonValidation();

    @Override
    public void test(String input) {
        commonValidation.isInputDigit(input);
        isMoneyExcess(input);
        isMoneyInsufficient(convertToInteger(input));
        isMoneyDividable(convertToInteger(input));
    }

    @Override
    public String printError(LottoErrors lottoErrors) {
        return lottoErrors.getError();
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isMoneyInsufficient(int money) {
        if (money < LottoSetting.MONEY_UNIT.getAttribute()) {
            throw new IllegalArgumentException(printError(ERROR_INSUFFICIENT_MONEY));
        }
    }

    private void isMoneyExcess(String input) {
        if (Long.parseLong(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(printError(ERROR_MONEY_EXCESS));
        }
    }

    private void isMoneyDividable(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(printError(ERROR_NON_DIVIDABLE));
        }
    }

}
